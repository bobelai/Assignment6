import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SizeTestStudent {

    @Test
    void testSizeEnum() {
        assertEquals(3, Size.values().length, "There should be 3 sizes in the Size enum.");
        assertEquals(Size.SMALL, Size.valueOf("SMALL"), "SMALL should exist in Size enum.");
        assertEquals(Size.MEDIUM, Size.valueOf("MEDIUM"), "MEDIUM should exist in Size enum.");
        assertEquals(Size.LARGE, Size.valueOf("LARGE"), "LARGE should exist in Size enum.");
    }
}
