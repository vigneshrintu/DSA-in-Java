
import java.util.*;

public class StackArray {

    public ArrayList<Integer> stack = new ArrayList<>();

    public boolean isEmpty() {
        return (stack.size() == 0);
    }

    public void push(int data) {
        stack.add(data);
    }

    public int pop() {
        if (stack.isEmpty()) {
            System.out.println("Empty stack");
            return Integer.MIN_VALUE;
        }
        int top = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return top;
    }

    public void display() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(" " + stack.get(i));
        }
        System.out.println();
    }

    public void insertInBottom(int data) {
        if (isEmpty()) {
            push(data);
            return;
        }
        int top = pop();
        insertInBottom(data);
        push(top);
    }

    public void reverseStack() {
        if (isEmpty()) {
            return;
        }
        int top = pop();
        reverseStack();
        insertInBottom(top);
    }

    public static boolean validParenthesis(String expression) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                s.push(current);
            } else {
                if (s.isEmpty()) {
                    return false;
                } else {
                    if ((current == '}' && s.peek() == '{') || (current == ')' && s.peek() == '(')
                            || (current == ']' && s.peek() == '[')) {
                        s.pop();
                    } else {
                        return false;
                    }
                }
            }

        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }

        /*
         * Initialize an empty stack.
         * Iterate through each character in the expression.
         * If it's an open parenthesis, push onto the stack.
         * If it's a closing parenthesis, check if the stack is empty or forms a valid
         * pair with the top of the stack.
         * If it forms a valid pair then pop the corresponding opening parenthesis from
         * the stack.
         * If at the end of the loop ,still the stack is not empty then return false.
         * Else return true.
         */
    }

    public static void main(String[] args) {
        boolean s = StackArray.validParenthesis("({[]}){{}}");
        System.out.println(s);
    }
}