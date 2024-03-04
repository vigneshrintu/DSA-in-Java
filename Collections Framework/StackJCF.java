import java.util.Stack;

public class StackJCF {

    public static void main(String[] args) {
        // Initializing a Stack
        Stack<Integer> stack = new Stack<>();

        // Pushing elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Popping an element
        int poppedElement = stack.pop();
        System.out.println("Popped Element: " + poppedElement);

        // Peeking at the top element
        int topElement = stack.peek();
        System.out.println("Top Element: " + topElement);

        // Searching for an element
        int position = stack.search(20);
        System.out.println("Position of 20: " + position);

        // Checking if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is Stack Empty? " + isEmpty);

        // Checking the size of the stack
        int size = stack.size();
        System.out.println("Size of Stack: " + size);
    }

}
