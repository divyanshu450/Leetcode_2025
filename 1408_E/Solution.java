import java.util.*;// importing package to run in local..

public class Solution {
    public static void main(String args[]){
        String[] words = {"mass","as","hero","superhero"};
        System.out.println("INPUT: "+Arrays.toString(words));
        List<String> result = stringMatching(words);
        System.out.println("OUTPUT: "+result.toString());

        //uncomment below lines to see each value in result list...
        /*  
        Iterator<String> itr = result.iterator();
        while (itr.hasNext()) {
            String word = itr.next();
            System.out.println(word);
        }
        */

    }

    //TC: O(n+k^2);
    //SC: O(k);
    //Using KPM Algorithm
    public static List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0 ; j <words.length; j++){
                // if(i == j) continue;
                boolean check = i!= j ? words[j].contains(words[i]) : false;
                if( check){
                    list.add(words[i]);
                    break;
                }
                
            }
        }
        return list;
    }

    /* 
    //TC: O(n log n + n^2 * k) where n is the number of words and k is the average length of the strings. Also O(n log n) is from Arrays.sort()
    //SC: O(n + k)
    public static List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<String>();
        Arrays.sort( words, new Comparator<String>() {
             @Override
             public int compare(String s1, String s2){
                return Integer.compare(s1.length(), s2.length());
             }
        });
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(int j = i+1; j <words.length; j++){
                String[] checkArr = words[j].split(word);
                if(checkArr.length > 0 && checkArr[0] == words[j]){//no split
                    continue;
                }
                if(checkArr.length > 0 && checkArr[0] != words[j])//means available
                {
                    list.add(word);
                    break;
                }
            }
        }
        return list;
    }
        */
}
