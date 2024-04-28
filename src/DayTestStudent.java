import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DayTestStudent {

    @Test
    void testDayEnum() {
        assertEquals(7, Day.values().length, "There should be 7 days in the Day enum.");
        assertEquals(Day.MONDAY, Day.valueOf("MONDAY"), "MONDAY should exist in Day enum.");
        assertEquals(Day.TUESDAY, Day.valueOf("TUESDAY"), "TUESDAY should exist in Day enum.");
        assertEquals(Day.WEDNESDAY, Day.valueOf("WEDNESDAY"), "WEDNESDAY should exist in Day enum.");
        assertEquals(Day.THURSDAY, Day.valueOf("THURSDAY"), "THURSDAY should exist in Day enum.");
        assertEquals(Day.FRIDAY, Day.valueOf("FRIDAY"), "FRIDAY should exist in Day enum.");
        assertEquals(Day.SATURDAY, Day.valueOf("SATURDAY"), "SATURDAY should exist in Day enum.");
        assertEquals(Day.SUNDAY, Day.valueOf("SUNDAY"), "SUNDAY should exist in Day enum.");
    }
}
