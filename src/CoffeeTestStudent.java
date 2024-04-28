import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeTestStudent {
    private Coffee coffee;

    @BeforeEach
    void setUp() {
        coffee = new Coffee("Espresso", Size.MEDIUM, true, true);
    }

    @Test
    void testConstructor() {
        assertAll("Constructor should set all properties correctly",
            () -> assertEquals("Espresso", coffee.getName(), "Name should be set by constructor."),
            () -> assertEquals(Size.MEDIUM, coffee.getSize(), "Size should be set by constructor."),
            () -> assertTrue(coffee.isExtraShot(), "Extra shot should be set by constructor."),
            () -> assertTrue(coffee.isExtraSyrup(), "Extra syrup should be set by constructor.")
        );
    }

    @Test
    void testCalcPrice() {
        // Price includes base price, size price for MEDIUM, and prices for extra shot and syrup
        double expectedPrice = 2.0 + 0.5 + 0.5 + 0.5; // Base price + size price + extra shot price + extra syrup price
        assertEquals(expectedPrice, coffee.calcPrice(), "CalcPrice should calculate the correct price with extras.");
    }

    @Test
    void testToString() {
        String expectedString = "Name: Espresso, Size: MEDIUM, Type: COFFEE, Price: $3.5, Extra Shot: true, Extra Syrup: true";
        assertEquals(expectedString, coffee.toString(), "toString should return the correct string representation with extras.");
    }

    @Test
    void testIsExtraShot() {
        assertTrue(coffee.isExtraShot(), "isExtraShot should return true when extra shot is true.");
    }

    @Test
    void testSetExtraShot() {
        coffee.setExtraShot(false);
        assertFalse(coffee.isExtraShot(), "setExtraShot should update the extra shot status correctly.");
    }

    @Test
    void testIsExtraSyrup() {
        assertTrue(coffee.isExtraSyrup(), "isExtraSyrup should return true when extra syrup is true.");
    }

    @Test
    void testSetExtraSyrup() {
        coffee.setExtraSyrup(false);
        assertFalse(coffee.isExtraSyrup(), "setExtraSyrup should update the extra syrup status correctly.");
    }
}
