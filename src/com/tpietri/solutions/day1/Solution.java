package com.tpietri.solutions.day1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int resultingFrequencyFromChanges(List<String> changes) {
        int result = 0;

        for (String change : changes) {
            // Computing next frequency
            result += Integer.parseInt(change);
        }

        return result;
    }

    public int firstFrequencyReachedTwice(List<String> changes) {
        int currentFrequency = 0;
        Set<Integer> reachedFrequencies = new HashSet<>();
        boolean reachedSameFrequencyTwice = false;
        int i = 0;
        while (!reachedSameFrequencyTwice) {
            // computing next frequency
            currentFrequency += Integer.parseInt(changes.get(i % changes.size()));

            //Check if frequency was allready reached
            reachedSameFrequencyTwice = reachedFrequencies.contains(currentFrequency);
            reachedFrequencies.add(currentFrequency);
            i++;
        }

        return currentFrequency;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/com/tpietri/solutions/day1/input.txt");
        List<String> lines = Files.readAllLines(file.toPath(), Charset.defaultCharset());

        Solution solution = new Solution();
        int solution1 = solution.resultingFrequencyFromChanges(lines);
        System.out.println(solution1);

        int solution2 = solution.firstFrequencyReachedTwice(lines);
        System.out.println(solution2);
    }
}
