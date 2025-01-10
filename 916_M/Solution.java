import java.util.*;

public class Solution {

    public static void main(String[] args) {
       String words1[] = {"amazon","apple","facebook","google","leetcode"}, words2[] = {"e","oo"};//= {"lo", "eo"};//words2[] = {"e","o"};
       Solution solution = new Solution();
       List<String> output = solution.wordSubsets(words1, words2);
       Iterator<String> itr = output.iterator();
       System.out.println("OUTPUT: "+output.size());
       while(itr.hasNext()){
        String word = itr.next();
        System.out.println(word);
       }
    }

    //TC: O(n*m + k) where n is len of words1, m is words[i] and k is all of words2...
    //SC: O(k) for storing frequency..
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        
        // Step 1: Count the maximum frequency of each character in words2
        Map<Character, Integer> requiredFreq = new HashMap<>();
        for (String word2 : words2) {
            Map<Character, Integer> tempFreq = new HashMap<>();
            for (char c : word2.toCharArray()) {
                // Manually handle the frequency count without getOrDefault
                int count = tempFreq.containsKey(c) ? tempFreq.get(c) : 0;
                tempFreq.put(c, count + 1);
            }
            // Update the requiredFreq map with the maximum frequency
            for (Map.Entry<Character, Integer> entry : tempFreq.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                int currentMax = requiredFreq.containsKey(key) ? requiredFreq.get(key) : 0;
                requiredFreq.put(key, Math.max(currentMax, value));
            }
        }
        
        // Step 2: Check each word in words1
        for (String word1 : words1) {
            Map<Character, Integer> word1Freq = new HashMap<>();
            for (char c : word1.toCharArray()) {
                // Manually handle the frequency count without getOrDefault
                int count = word1Freq.containsKey(c) ? word1Freq.get(c) : 0;
                word1Freq.put(c, count + 1);
            }
            
            boolean isValid = true;
            // Step 3: Check if word1 contains all characters from words2 with required frequency
            for (Map.Entry<Character, Integer> entry : requiredFreq.entrySet()) {
                char c = entry.getKey();
                int requiredCount = entry.getValue();
                int currentCount = word1Freq.containsKey(c) ? word1Freq.get(c) : 0;
                if (currentCount < requiredCount) {
                    isValid = false;
                    break; // If any character is missing or insufficient, break early
                }
            }
            
            // If word1 is valid, add it to the result list
            if (isValid) {
                list.add(word1);
            }
        }
        
        return list;
    }

}
