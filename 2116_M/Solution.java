public class Solution {

    public static void main(String[] args) {
        String s = "))()))", locked = "010100";
        Solution solution = new Solution();
        boolean output = solution.canBeValid(s, locked);
        System.out.println("OUTPUT: "+output);
    }


    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int leftOpen = 0, rightClose = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                leftOpen++;
            } else {
                rightClose++;
            }

            if (rightClose > leftOpen) {
                return false;
            }
        }

        leftOpen = 0;
        rightClose = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                rightClose++;
            } else {
                leftOpen++;
            }

            if (leftOpen > rightClose) {
                return false;
            }
        }
        return true;
    }
    
}
