import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String words[] = {"pay","attention","practice","attend"};
        String pref = "at";
        System.out.println("INPUT: "+ Arrays.toString(words));
        Solution solution = new Solution();
        int ans = solution.prefixCount(words, pref);
        System.out.println("OUTPUT: "+ans);
    }
    //TC: O(n)
    //SC: 0(1)
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].startsWith(pref)) ans++;
        }
        return ans;
    }
}
