import java.util.*;

public class KadanesAlgorithm {
    public static void maxSumBrute(int arr[]) {
        //call this function and see console to understand it clearly
        int totalSubArrs = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    currSum += arr[k];
                }
                totalSubArrs++;
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
                System.out.println();
            }
        }
        System.out.println("maxSumOfSubArray " + maxSum);
        System.out.println("totalSubArrs " + totalSubArrs);
    }

    public static void maxSumOptimised(int arr[]) {
        int prefix[] = new int[arr.length];
        // In a prefix array, i th index will have sum of all elements till i th index
        // beginning from 0th index
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
            // sumAtiThIndex = sumTill(i-1)ThIndex + currentIndexValue
        }
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == 0) {
                    currSum = prefix[j];
                } else {
                    currSum = prefix[j] - prefix[i - 1];
                }
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println();
        // This code does the same thing as printSub but here there is no third for loop
        // since we optimised with if else so that there is no need of third for loop.
        // The third for loop in printSub does the same thing as the ifelse in this
        // function.
        // We can modify original array or else use extra space for creating prefix
        // array.

    }

    public static void kadanesAlgo(int arr[]) {
        /*
            find the sum of all elements in the array and during this process:
                if sum<0 then put sum=0
                and
                always check if the sum>maxSum and update 
        */
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                // when sum is zero then it means newSubArray has started and we don't know if
                // it will contain maxSum but we assume and if it won't contain maxSum then
                // another sub array will start and we have its beginning index in start
                start = i;
            }
            if (sum < 0) {
                sum = 0;

            }
            if (sum > maxSum) {
                maxSum = sum;
                // newSubArray ends when maxSum is updated lastly
                end = i;
            }
            

        }
        System.out.println(maxSum + " is maxSum");
        System.out.println(start + " " + end + " is the indices of the subArray with maxSum");
        // Incase of all negative numbers in an array then find the biggest number in it
        // and it is the answer.
        // Kadanes Algo won't work for an array with all negative numbers.
    }

    public static void letmeloveyou(int arr[],int k){
        int sum=0;
        int prevlength=0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                sum=0;
                for(int z=i;z<=j;z++){
                    sum+=arr[z];
                }
                if(sum==k && prevlength<=j-i+1){
                    prevlength=j-i+1;
                }
            }
        }
        System.out.println(prevlength);
    }



    public static void main(String[] args) {
        int arr[] = { 1, 2,3,1,1,1,2,-1,-1,1,-1,1,-1,1,-1,1,5};
        letmeloveyou(arr,3);
        
    }
}