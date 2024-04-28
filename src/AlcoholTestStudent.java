import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlcoholTestStudent {
    private Alcohol alcohol;

    @BeforeEach
    void setUp() {
        alcohol = new Alcohol("Vodka", Size.MEDIUM, true);
    }

    @Test
    void testConstructor() {
        assertAll("Constructor should correctly set all fields",
            () -> assertEquals("Vodka", alcohol.getName(), "Name should be set by constructor."),
            () -> assertEquals(Size.MEDIUM, alcohol.getSize(), "Size should be set by constructor."),
            () -> assertEquals(Type.ALCOHOL, alcohol.getType(), "Type should be ALCOHOL."),
            () -> assertTrue(alcohol.isWeekend(), "Weekend should be set by constructor.")
        );
    }

    @Test
    void testCalcPrice() {
        // Price should include base price, size price for MEDIUM, and weekend price.
        double expectedBasePrice = 2.0; // From Beverage class
        double expectedSizePrice = 0.5; // Additional size price for MEDIUM
        double expectedWeekendPrice = 0.6; // Weekend surcharge
        double expectedPrice = expectedBasePrice + expectedSizePrice + expectedWeekendPrice;
        assertEquals(expectedPrice, alcohol.calcPrice(), "calcPrice should calculate the correct price.");
    }

    @Test
    void testToString() {
        String expectedString = "Name: Vodka, Size: MEDIUM, Type: ALCOHOL, Price: $3.1, Weekend: true";
        assertEquals(expectedString, alcohol.toString(), "toString should return correct string representation.");
    }

    @Test
    void testIsWeekend() {
        assertTrue(alcohol.isWeekend(), "isWeekend should return true when set to true.");
    }

    @Test
    void testSetWeekend() {
        alcohol.setWeekend(false);
        assertFalse(alcohol.isWeekend(), "setWeekend should update the weekend field correctly.");
    }
}
