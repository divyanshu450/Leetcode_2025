class Solution{
    public static void main(String[] args) {
        System.out.println("Hello World");
        String boxes = "011";
        int outputArray[] = minOperations(boxes);
        for(int i=0; i<outputArray.length; i++){
            System.out.println(outputArray[i]);
        }
    }

    // TC: O(n), SC: O(n)
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] outputArray = new int[n];

        int leftSum = 0;  
        int leftCount = 0;
        for (int i = 0; i < n; i++) {
            outputArray[i] = leftSum;  
            if (boxes.charAt(i) == '1') {
                leftCount++;  
            }
            leftSum += leftCount;
        }

        int rightSum = 0;  
        int rightCount = 0; 
        for (int i = n - 1; i >= 0; i--) {
            outputArray[i] += rightSum; 
            if (boxes.charAt(i) == '1') {
                rightCount++;  
            }
            rightSum += rightCount;  
        }

        return outputArray;
    }

    /* TC: O(n^2), SC: O(n)
    public static int[] minOperations(String boxes){
        int n = boxes.length();
        int outputArray[] = new int[n];
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                if(boxes.charAt(j) == '1'){
                    sum += Math.abs(i-j);
                }
            }
            outputArray[i] = sum;
        }
        return outputArray;
    }
        */
}
