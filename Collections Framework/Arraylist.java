import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {
        // Declare an ArrayList
        ArrayList<String> list = new ArrayList<>();

        // Initialize with values
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Add elements
        list.add("Item1");
        list.add("Item2");

        // Access elements
        String item = list.get(0);

        // Remove element by index
        list.remove(1);

        // Remove element by value
        list.remove("Item1");

        // Get size
        int size = list.size();

        // Check if empty
        boolean isEmpty = list.isEmpty();

        // Clear the ArrayList
        list.clear();

        // Iterate through ArrayList
        for (String listItem : list) {
            System.out.println(listItem);
        }

        // 2D ArrayList
        ArrayList<ArrayList<Integer>> twoDList = new ArrayList<>();

        // Add rows without using List.of()
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        twoDList.add(row1);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        twoDList.add(row2);

        // Access element in 2D ArrayList
        int element = twoDList.get(0).get(1);
        System.out.println("Element at (0,1): " + element);

        // Print 2D ArrayList (Matrix) in comments
        System.out.println("\nMatrix (2D ArrayList):");
        // [1, 2, 3]
        // [4, 5, 6]
        for (ArrayList<Integer> row : twoDList) {
            System.out.println(row);
        }
    }
}
