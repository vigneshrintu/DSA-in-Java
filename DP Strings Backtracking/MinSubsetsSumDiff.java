
    /*
     
    ->In the knapsack problem, we aim to maximize the total value of items that can be included in a knapsack with a weight capacity constraint. In the DP table for this problem, the value at each index dp[i][j] represents the maximum value that can be achieved with the first i items and a total weight capacity of j.
    ->In the subset sum problem, we are trying to determine if a subset with a given sum exists in the array. In the DP table for this problem, the value at each index dp[i][j] represents whether it is possible to form the sum j using the first i elements of the array.
    ->Note all the above points were valid when we use tablulation dp array like either in memorisation or dp solution but not in recursive brute solution because brute recursive solution  always tries to find all possible paths by once including item and excluding item and finally skips the item if it is not possible to include the item.
    ->The minSubsetsSumDiff uses subset sum problem dp array and to find the answer.
    ->The s1 and s2 should have min diff as per problem and s1+s2=total arr sum.
    ->So the if we assume all elements exists in one subset and another subset is empty then in this case we get max subsets sum diff which is total arr sum.
    ->When s1 and s2 are equal which is the case in where we get min subsets sum that is zero.
    ->So finally the range of subset sum diff is 0 to totalArrSum.
    ->if we find one subset either s1 or s2 then we can say that s2=totalArrSum-s2.
    ->if we wanted to find the subset sum diff then : subset sum diff = s2-(totalArrSum-s2)
        2*s2-totalArrSum is the subset sum diff.
    ->Here comes the actual logic :
        - since the range for min subsets diff is always lies in between 0 to totalArrSum
        - we know that min possible value for min subsets sum is 0 which results when the s1==s2 and it only goes up but not down that implies either s1 or s2 is always <= to one another.
        - assume s1 <=s2 when means s1 will have a sum in the range of 0 to totalArrSum/2.
        - now we have to find the min possible sum value in between 0 to totalArrSum/2.
        - which can be found using the subset sum problem logic because in that table we have 
        " In the subset sum problem, we are trying to determine if a subset with a given sum exists in the array. In the DP table for this problem, the value at each index dp[i][j] represents whether it is possible to form the sum j using the first i elements of the array. "
        - in the problem also we will check all possible sums of last row only because if we go for last row then the sums there formed were made from all the array elements(that does not mean all array elements were considered to make the sums, just it means we have used all elements combinations to find whether the sum is possible or not) if the sum is possible then we get true else we get false and combination means we have all elements in choice to choose from to make the sum given but not necessary that we use all elements.
        


        




    */

    public class MinSubsetsSumDiff {

        /*
        This function calculates the minimum difference between the sums of two subsets of a given array.
        It uses dynamic programming to determine the subset sums that are possible and finds the subset 
        with the sum closest to half of the total sum to minimize the difference.
        */
    


        //code to for the problem which checks whether the subset is possible or not with given sum
        public int solve(int[] arr) {
            int n = arr.length;
            int totalArrSum = 0;
    
            
            for (int i = 0; i < n; i++) {
                totalArrSum += arr[i];
            }
    
            // dp[i][j] will be true if a subset with sum j can be formed using the first i elements
            boolean[][] dp = new boolean[n + 1][totalArrSum + 1];
    
            // Initialize the DP table
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true; // Sum 0 is always possible with any number of elements because we donot include any element and form a empty subset which has sum zero.
            }
    
            for (int j = 1; j <= totalArrSum; j++) {
                dp[0][j] = false; // Non-zero sum is not possible with 0 elements
            }
    
            // Fill the DP table
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= totalArrSum; j++) {
                    if (arr[i - 1] > j) {
                        // If the current element is greater than the sum, we can't include it because it itself greater than the sum so we have to ignore and go for other.
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // Otherwise, we check if we can form the sum either including or excluding the current element.
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    }
                }
            }
    
            // Find the min subsets sum diff possible
            int minSubsetSumDiff = Integer.MAX_VALUE;
            for (int s1 = 0; s1 <= totalArrSum / 2; s1++) {
                //here we are fixing n because refer to last comment in explanation.
                if (dp[n][s1]) {
                    // If a subset with sum s1 is possible, check the difference
                    int s2 = totalArrSum - s1;
                    minSubsetSumDiff = Math.min(minSubsetSumDiff, Math.abs(s2 - s1));
                }
            }
    
            return minSubsetSumDiff;
        }
    }
    
    

