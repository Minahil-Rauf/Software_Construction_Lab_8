package test;

import org.junit.jupiter.api.Test;
import recursions.RecursiveFileSearch;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RecursiveFileSearchTest {

    @Test
    void testFileFound() {
        List<String> result = RecursiveFileSearch.searchFiles(".", "Main.java", false);
        assertNotNull(result);
    }

    @Test
    void testInvalidDirectoryThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                RecursiveFileSearch.searchFiles("invalid/path", "file.txt", false));
    }

    @Test
    void testCaseSensitivity() {
        List<String> caseInsensitive = RecursiveFileSearch.searchFiles(".", "main.java", false);
        List<String> caseSensitive = RecursiveFileSearch.searchFiles(".", "main.java", true);
        assertTrue(caseInsensitive.size() >= caseSensitive.size());
    }
}
