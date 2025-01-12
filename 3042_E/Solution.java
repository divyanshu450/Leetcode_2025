import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String words[] = {"a","aba","ababa","aa"};
        System.out.println("INPUT: "+ Arrays.toString(words));
        Solution solution = new Solution();
        int ans = solution.countPrefixSuffixPairs(words);
        System.out.println("OUTPUT: "+ans);
    }

    //TC: O(n^2+m) where n is longth of words array and m is the length of each word..
    // SC: O(1)
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            ans = isPrefixAndSuffix(i, words, false, ans);
        }
        return ans;
    }

    public int isPrefixAndSuffix(int i, String[] words, boolean bool, int ans){
        for(int j = 0; j < words.length; j++){
            if(i == j) continue;
            if(i< j && (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) ) ++ans;
            //Uncomment this to see initial thought process of a no-brainer..
            /* 
            //int currWordSum = words[i].length();
            // if(words[j].contains(words[i]) && i < j){
            //     String prefix = words[j].substring(0, currWordSum);
            //     String suffix = words[j].substring(words[j].length() - currWordSum, words[j].length());//(Math.abs(currWordSum - words[j].length()), words[j].length());
            //     if(prefix.equals(suffix) && prefix.equals(words[i]) ) ++ans;
            // }
            */
        }
        return ans;
    }
}
