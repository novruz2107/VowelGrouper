package com.novruz.task.impl;

import com.novruz.task.domain.VowelProps;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;


public class WordAverageServiceImplTest {

    @Test
    public void doTask_returnError_IfSentenceIsEmpty() {
        WordAverageServiceImpl wordAverageService = new WordAverageServiceImpl();
        String sentence = "";

        var response = wordAverageService.doTask(sentence);

        Assert.assertEquals("Bad input. Please provide a correct input.", response.getErrorMessage());
        Assert.assertNull(response.getData());
    }

    @Test
    public void doTask_returnGroupedVowels_IfSentenceIsProvided() {
        WordAverageServiceImpl wordAverageService = new WordAverageServiceImpl();
        String sentence = "Platon made bamboo boats.";

        VowelProps vowelProps1 = new VowelProps(Set.of('a', 'o'), 6, 2.5);
        VowelProps vowelProps2 = new VowelProps(Set.of('a', 'o'), 5, 2);
        VowelProps vowelProps3 = new VowelProps(Set.of('a', 'e'), 4, 2);
        List<VowelProps> vowelPropsList = List.of(vowelProps1, vowelProps2, vowelProps3);

        var response = wordAverageService.doTask(sentence);

        Assert.assertEquals("no error.", response.getErrorMessage());
        Assert.assertEquals(vowelPropsList, response.getData());
    }
}