package com.novruz.task.domain;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class VowelProps {
    private Set<Character> setOfVowels;
    private int lengthOfWord;
    private double averageVowels;
}
