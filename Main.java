package recursions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Task 1: Recursive File Search ===");
        try {
            List<String> foundFiles = RecursiveFileSearch.searchFiles(".", "Main.java", false);
            System.out.println("Found: " + foundFiles.size() + " occurrence(s)");
            foundFiles.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Task 2: String Permutations ===");
        try {
            List<String> permutations = StringPermutations.generatePermutations("ABC", false);
            System.out.println("Permutations (Recursive): " + permutations);
            System.out.println("Count: " + permutations.size());

            List<String> iterative = StringPermutations.generatePermutationsIterative("ABC");
            System.out.println("Permutations (Iterative): " + iterative);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
