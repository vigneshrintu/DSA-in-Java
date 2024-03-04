public class Array {
    public int findFifthLargest(int arr[]) {
        // Check if the array has at least five elements
        if (arr.length < 5) {
            System.out.println("Array should have at least five elements.");
            return -1; // Return a special value to indicate an error
        }

        // Initialize variables to store the five largest elements
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        int fourthLargest = Integer.MIN_VALUE;
        int fifthLargest = Integer.MIN_VALUE;

        // Iterate through the array
        for (int num : arr) {
            // If the current element is greater than the largest element
            if (num > largest) {
                // Update fifthLargest, fourthLargest, thirdLargest, secondLargest, and largest
                // elements
                fifthLargest = fourthLargest;
                fourthLargest = thirdLargest;
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            }
            // If the current element is greater than the fifthLargest but not equal to the
            // largest, secondLargest, thirdLargest, or fourthLargest
            else if (num > fifthLargest && num != largest && num != secondLargest && num != thirdLargest
                    && num != fourthLargest) {
                // Update only the fifthLargest element
                fifthLargest = num;
            }
        }

        // Return the fifth largest element
        return fifthLargest;
    }

    /*
     * ->IF YOU ARE ASKED TO FIND THE UNION OF TWO SORTED ARRAYS THEN JUST ADD THOSE
     * TWO ARRAYS IN TO A SINGLE ARRAY BY
     * USING MERGING OF TWO SORTED ARRAYS LOGIC AND FINALLY USE THE LOGIC OF REMOVE
     * DUPLICATES IN A SORTED ARRAY.
     */
    public static void main(String[] args) {

    }
}