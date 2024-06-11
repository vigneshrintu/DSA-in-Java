
//FOLLOW THIS LINK FOR ANY QUERY RELATED TO THIS THROUGH ANIMATION : https://youtu.be/MK-NZ4hN7rs?si=AanV5xlRNaSGRexd


public class SlidingWindow {
    public static int findMaxSumSubarray(int[] nums, int k) {
        
        if (nums == null || nums.length == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        // Calculate initial sum of the first window
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        // Sliding window of size k will slide over the array of size n
        for (int i = k; i < n; i++) {
            // add next new element in to the window
            currentSum += nums[i];
            
            // remove last element from the window
            currentSum -= nums[i - k];

            // max sum updation
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 3;

        
    }
}
