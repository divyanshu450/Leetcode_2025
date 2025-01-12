import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        Solution solution = new Solution();
        List<Integer> answer = solution.zigzagTraversal(grid);
        System.out.println("OUTPUT: "+ answer);
     }

    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<Integer>();
        boolean wasAdded = false;
        for(int i = 0; i < grid.length; i++){
            int[] arr = grid[i];
            if(i % 2 == 0){
                for(int j = 0 ; j < arr.length; j++){
                    if(!wasAdded){
                    list.add(arr[j]);
                    wasAdded = true;
                    }
                    else{
                    wasAdded = false;
                    }
                }
            }
            else{
                for(int j = arr.length-1 ; j > -1; j--){
                    if(!wasAdded){
                    list.add(arr[j]);
                    wasAdded = true;
                    }
                    else{
                    wasAdded = false;
                    }
                }

            }
        }

        return list;
    }
}
