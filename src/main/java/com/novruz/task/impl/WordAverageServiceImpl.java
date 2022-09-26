package com.novruz.task.impl;

import com.novruz.task.WordAverageService;
import com.novruz.task.domain.Response;
import com.novruz.task.domain.VowelProps;
import com.novruz.task.domain.Word;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WordAverageServiceImpl implements WordAverageService {

    @Override
    public Response<List<VowelProps>> doTask(String sentence) {
        if (sentence == null || sentence.equals("")) {
            return new Response<>("Bad input. Please provide a correct input.");
        }

        sentence = sentence.trim().toLowerCase();
        String[] words = sentence.split("([^a-z']+)'*\\1*");
        List<Word> wordProps = getVowelProps(words);

        var groupedWords = wordProps
                .stream()
                .collect(Collectors.groupingBy(Word::getLength, Collectors.groupingBy(Word::getSetOfVowels)));

        List<VowelProps> vowelPropsList = new ArrayList<>();
        for (var i : groupedWords.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            for (var j : groupedWords.get(i).entrySet()) {
                int vowelCountSum = j.getValue().stream().mapToInt(Word::getCountOfVowels).sum();
                int count = j.getValue().size();
                VowelProps vowelProps = new VowelProps(j.getKey(), i, (double) vowelCountSum / (double) count);

                vowelPropsList.add(vowelProps);
            }
        }
        return new Response<>(vowelPropsList);
    }

    private List<Word> getVowelProps(String[] words) {
        List<Word> wordProps = new ArrayList<>();

        for (String s : words) {
            Word word = new Word();
            word.setLength(s.length());
            var vowels = s
                    .chars()
                    .filter(c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            word.setCountOfVowels(vowels.size());
            word.setSetOfVowels(new HashSet<>(vowels));
            wordProps.add(word);
        }
        return wordProps;
    }
}
