package com.tpietri.solutions.day2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class Solution {

    public int calculateCheckSum(List<String> input) {
        int nbOfTwo = 0;
        int nbOfThree = 0;
        for (String currentString : input) {
            int[] nbOfLetters = new int[26];
            for (Character c : currentString.toCharArray()) {
                nbOfLetters[c - 'a']++;
            }
            boolean foundTwo = false;
            boolean foundThree = false;
            for (int i = 0; i < nbOfLetters.length && (!foundTwo || !foundThree); i++) {
                if (nbOfLetters[i] == 2 && !foundTwo) {
                    foundTwo = true;
                    nbOfTwo++;
                } else if (nbOfLetters[i] == 3 && !foundThree) {
                    foundThree = true;
                    nbOfThree++;
                }
            }
        }

        return nbOfThree * nbOfTwo;
    }

    public String findCommonLetters(List<String> input) {
        String output = "";

        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = i + 1; j < input.size(); j++) {
                // Comparing all pairs
                String box1Id = input.get(i);
                String box2Id = input.get(j);
                int nbOfDifferentLetters = 0;
                for (int k = 0; k < box1Id.length() && nbOfDifferentLetters < 2; k++) {
                    if (box1Id.charAt(k) != box2Id.charAt(k)) {
                        nbOfDifferentLetters++;
                    }
                }
                if (nbOfDifferentLetters == 1) {
                    for (int k = 0; k < box1Id.length(); k++) {
                        if (box1Id.charAt(k) == box2Id.charAt(k)) {
                            output += box1Id.charAt(k);
                        }
                    }
                    return output;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/com/tpietri/solutions/day2/input.txt");
        List<String> lines = Files.readAllLines(file.toPath(), Charset.defaultCharset());

        Solution solution = new Solution();
        int checkSum = solution.calculateCheckSum(lines);
        System.out.println(checkSum);

        String commonLetters = solution.findCommonLetters(lines);
        System.out.println(commonLetters);

    }
}
