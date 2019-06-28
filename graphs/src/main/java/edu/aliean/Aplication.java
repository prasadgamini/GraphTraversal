package edu.aliean;

import java.util.List;

public class Aplication {
    public static void main(String[] args) {
        AlianDictonaryProblem alianDictonary = new AlianDictonaryProblem();
        List<Character> orderedChars = alianDictonary.getOrderedChars(new String[]{"baa", "abcd", "abca", "cab", "cad"});
        orderedChars.forEach(System.out::println);
    }
}
