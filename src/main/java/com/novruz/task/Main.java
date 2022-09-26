package com.novruz.task;

import com.novruz.task.domain.VowelProps;
import com.novruz.task.impl.WordAverageServiceImpl;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final WordAverageService wordAverageService = new WordAverageServiceImpl();

    public static void main(String[] args) {
        try {
            FileReader reader =
                    new FileReader("INPUT.txt");
            int character;
            StringBuilder sentence = new StringBuilder();
            while ((character = reader.read()) != -1) {
                sentence.append((char) character);
            }

            var response = wordAverageService.doTask(sentence.toString());
            if (response.getData() != null) {
                FileWriter writer = new FileWriter("OUTPUT.txt", false);
                for (VowelProps vp : response.getData()) {
                    writer.write(
                            "(" + vp.getSetOfVowels() + ", " + vp.getLengthOfWord() + ") -> " + vp.getAverageVowels() +
                                    "\n");
                }
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
