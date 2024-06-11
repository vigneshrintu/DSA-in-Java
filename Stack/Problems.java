import java.util.*;

public class Problems {

    public static HashMap<Integer,Integer> nGETR(int[] arr) {
        // nextGreaterElementToRight
        // explanation available in between 14 to 17 minutes in aditya verma
        HashMap<Integer, Integer> hp = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            
            if(stack.size()==0){
                hp.put(arr[i],-1);
            }
            else if(stack.size()>0 && stack.peek()>arr[i]){
                hp.put(arr[i],stack.peek());
            }
            else if(stack.size()>0 && stack.peek()<=arr[i]){
                while (stack.size()>0 && stack.peek()<=arr[i]) {
                    stack.pop();   
                }
                if(stack.size()==0){
                    hp.put(arr[i],-1);
                }
                else if(stack.peek()>arr[i]){
                    hp.put(arr[i],stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return hp;
        /*
        ->Since we are finding nGETR we need to iterate from right to left,incase of nGETL then left to right.
        ->If stack size becomes zero at any point in the iteration then put that arr[i] key value to -1 which means
        no element is found greater to the right of that arr[i] in the Array.
        - We ideally put -1 everytime for right most element since there is no elements to the right of that last element.
        ->whenever top of stack is greater than arr[i] then put arr[i] key value to top element.
        ->if top of stack is less than arr[i] then pop from stack until stack is not empty and arr[i] is less than top element of stack.
            - if stack becomes empty and loop got terminated, then put arr[i] key value to -1.
            - if stack top greater than arr[i] and loop got terminated, then put arr[i] key value to top element.
        ->at the end of every iteration, push arr[i] into the stack.
        */
    }


    public static HashMap<Integer,Integer> nGETL(int[] arr) {
        // nextGreaterElementToLeft
        /*
            ->Just iterate from left to right since we have to find the nGETL.
        */
        HashMap<Integer, Integer> hp = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            
            if(stack.size()==0){
                hp.put(arr[i],-1);
            }
            else if(stack.size()>0 && stack.peek()>arr[i]){
                hp.put(arr[i],stack.peek());
            }
            else if(stack.size()>0 && stack.peek()<=arr[i]){
                while (stack.size()>0 && stack.peek()<=arr[i]) {
                    stack.pop();   
                }
                if(stack.size()==0){
                    hp.put(arr[i],-1);
                }
                else if(stack.peek()>arr[i]){
                    hp.put(arr[i],stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return hp;
        
    }

    public static HashMap<Integer,Integer> nSETL(int[] arr) {
        // nextSmallerElementToLeft
        /*
            ->Just iterate from left to right since we have to find the nGETL.
            ->Same as nGETL but lessthan becomes greaterthan and greaterthan becomes lessthan
        */
        HashMap<Integer, Integer> hp = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            
            if(stack.size()==0){
                hp.put(arr[i],-1);
            }
            else if(stack.size()>0 && stack.peek()<arr[i]){
                hp.put(arr[i],stack.peek());
            }
            else if(stack.size()>0 && stack.peek()>=arr[i]){
                while (stack.size()>0 && stack.peek()>=arr[i]) {
                    stack.pop();   
                }
                if(stack.size()==0){
                    hp.put(arr[i],-1);
                }
                else if(stack.peek()>arr[i]){
                    hp.put(arr[i],stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return hp;
        
    }
    

    
    public static void main(String args[]){
        // int arr[]={5,4,3,2,1,7,6};why nSETL not working for this test case
        // HashMap<Integer,Integer> hp=nSETL(arr);
        // System.out.println(hp);

        

    }
}
