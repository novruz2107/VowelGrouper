package com.novruz.task.domain;

import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Word {
    private int length;
    private int countOfVowels;

    private Set<Character> setOfVowels;
}
