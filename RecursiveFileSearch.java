package recursions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecursiveFileSearch {

    /**
     * Recursively searches for files by name within a directory and its subdirectories.
     *
     * @param directoryPath the starting directory
     * @param fileName name of the file to search
     * @param caseSensitive true if the search should be case-sensitive
     * @return list of file paths that match
     */
    public static List<String> searchFiles(String directoryPath, String fileName, boolean caseSensitive) {
        List<String> foundFiles = new ArrayList<>();
        File dir = new File(directoryPath);

        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path: " + directoryPath);
        }

        searchHelper(dir, fileName, caseSensitive, foundFiles);
        return foundFiles;
    }

    // Recursive helper method
    private static void searchHelper(File dir, String fileName, boolean caseSensitive, List<String> foundFiles) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                searchHelper(file, fileName, caseSensitive, foundFiles);
            } else {
                String current = file.getName();
                if (caseSensitive ? current.equals(fileName) : current.equalsIgnoreCase(fileName)) {
                    foundFiles.add(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java RecursiveFileSearch <directory> <fileName> [caseSensitive]");
            return;
        }

        String directory = args[0];
        String fileName = args[1];
        boolean caseSensitive = args.length > 2 && args[2].equalsIgnoreCase("true");

        try {
            List<String> results = searchFiles(directory, fileName, caseSensitive);
            if (results.isEmpty()) {
                System.out.println("File not found.");
            } else {
                System.out.println("File(s) found:");
                for (String path : results) {
                    System.out.println(path);
                }
                System.out.println("Occurrences: " + results.size());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
