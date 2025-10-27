package test;

import org.junit.jupiter.api.Test;
import recursions.StringPermutations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StringPermutationsTest {

    @Test
    void testPermutationCountForABC() {
        List<String> result = StringPermutations.generatePermutations("ABC", true);
        assertEquals(6, result.size());
    }

    @Test
    void testEmptyInputThrows() {
        assertThrows(IllegalArgumentException.class, () ->
                StringPermutations.generatePermutations("", true));
    }

    @Test
    void testIterativeEqualsRecursiveForAB() {
        List<String> rec = StringPermutations.generatePermutations("AB", true);
        List<String> iter = StringPermutations.generatePermutationsIterative("AB");
        assertEquals(rec.size(), iter.size());
        assertTrue(rec.containsAll(iter));
    }
}
