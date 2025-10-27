package recursions;

import java.util.*;

public class StringPermutations {

    public static List<String> generatePermutations(String input, boolean allowDuplicates) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty.");
        }

        Set<String> resultSet = new HashSet<>();
        permute("", input, resultSet);

        List<String> result = new ArrayList<>(resultSet);
        if (!allowDuplicates) {
            // Removing duplicates explicitly if not allowed
            result = new ArrayList<>(new HashSet<>(result));
        }
        return result;
    }

    private static void permute(String prefix, String remaining, Set<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                permute(prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1),
                        result);
            }
        }
    }

    // Non-recursive (iterative) method for comparison
    public static List<String> generatePermutationsIterative(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be empty.");
        }

        List<String> result = new ArrayList<>();
        result.add(String.valueOf(input.charAt(0)));

        for (int i = 1; i < input.length(); i++) {
            List<String> newList = new ArrayList<>();
            for (String s : result) {
                for (int j = 0; j <= s.length(); j++) {
                    newList.add(s.substring(0, j) + input.charAt(i) + s.substring(j));
                }
            }
            result = newList;
        }
        return result;
    }

    // 🟢 New main method with user option
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to generate its permutations:");
        String input = scanner.nextLine();

        System.out.println("Include duplicate permutations? (yes/no):");
        String choice = scanner.nextLine().trim().toLowerCase();

        boolean allowDuplicates = choice.equals("yes");

        try {
            System.out.println("\n--- Recursive Permutations ---");
            List<String> recursivePerms = generatePermutations(input, allowDuplicates);
            System.out.println(recursivePerms);
            System.out.println("Count: " + recursivePerms.size());

            System.out.println("\n--- Iterative Permutations ---");
            List<String> iterativePerms = generatePermutationsIterative(input);
            System.out.println(iterativePerms);
            System.out.println("Count: " + iterativePerms.size());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
