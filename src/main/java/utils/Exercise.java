package utils;

import java.util.Map;

public class Exercise {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public Map<Character, Integer> countCharacters(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
        Map<Character, Integer> characterCount = new java.util.HashMap<>();
        for (char c : input.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }
        return characterCount;
    }
}
