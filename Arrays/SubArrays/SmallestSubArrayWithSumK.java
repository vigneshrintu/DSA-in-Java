
//FOLLOW THIS LINK FOR ANY QUERY RELATED TO THIS THROUGH ANIMATION : https://youtu.be/MK-NZ4hN7rs?si=AanV5xlRNaSGRexd

public class SmallestSubArrayWithSumK {
 
    public static int smallestSubarray(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd]; // Add the next element to the window sum

            // Shrink the window as small as possible until the window sum is less than k
            while (windowSum >= k) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1); // Update min length
                windowSum -= nums[windowStart]; // Subtract the element going out of the window
                windowStart++; // Slide the window to the right
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 2, 3, 2};
        int k = 7;
        int minLength = smallestSubarray(nums, k);
        System.out.println("Smallest subarray length: " + minLength);
    }
}
