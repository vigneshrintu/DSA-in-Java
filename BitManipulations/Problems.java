package BitManipulations;

public class Problems {

    public static boolean isKthBitSet(int n, int k) {
        // Shift 1 to the left by k-1 times to create a mask with only the kth bit set
        int mask = 1 << (k - 1);
        // If the result is non-zero, then the kth bit is set; otherwise, it's not set
        return (n & mask) != 0;
    }

    static int clearKthSetBit(int n, int k) {
        // Shift 1 to the left by k-1 times to create a mask with only the k-th bit set and compliment it
        int mask = ~(1 << (k - 1));
        // Perform bitwise AND operation between the number and the mask to clear the k-th bit
        return (n & mask);
        //despite the Kth bit is set or not, it will unset that bit means if the kth bit is 1 it will become 0 and if it is 0 then it remains as 0.
    }

    public static boolean isOdd(int n){
        //n&1 returns the last digit of n from its binary format
        //if last digit is one then it is odd else it is even
        //MAKE SURE (N&1) IS ENCLOSED INSIDE PARENTHESIS ELSE IT WILL COME FROM RIGHT TO LEFT AND EVALUTES == FIRST.
        return ( n&1 ) == 1;
    }

    public static boolean isPowerOfTwo(int n){
        if(n==0 || n<0){
            return false;
        }
        return (n&(n-1))==0;
    }

    public static void swapNumber(int []a, int []b) {
        a[0]=a[0]^b[0];
        b[0]=a[0]^b[0];
        a[0]=a[0]^b[0];
    }

    



    
    
    
}
