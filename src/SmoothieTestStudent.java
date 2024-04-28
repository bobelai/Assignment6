import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmoothieTestStudent {
    private Smoothie smoothie;

    @BeforeEach
    void setUp() {
        smoothie = new Smoothie("Berry Delight", Size.LARGE, 3, true);
    }

    @Test
    void testConstructor() {
        assertAll("Constructor should set all properties correctly",
            () -> assertEquals("Berry Delight", smoothie.getName(), "Name should be set by constructor."),
            () -> assertEquals(Size.LARGE, smoothie.getSize(), "Size should be set by constructor."),
            () -> assertEquals(3, smoothie.getNumOfFruits(), "Number of fruits should be set by constructor."),
            () -> assertTrue(smoothie.isAddProtein(), "Protein addition should be set by constructor.")
        );
    }

    @Test
    void testCalcPrice() {
        // Price includes base price, size price for LARGE, price per fruit, and protein price
        double expectedBasePrice = 2.0; // Base price from Beverage class
        double expectedSizePrice = 2 * 0.5; // Additional size price for LARGE
        double expectedFruitPrice = 3 * 0.5; // Price for 3 fruits
        double expectedProteinPrice = 1.5; // Price for protein
        double expectedPrice = expectedBasePrice + expectedSizePrice + expectedFruitPrice + expectedProteinPrice;
        assertEquals(expectedPrice, smoothie.calcPrice(), "CalcPrice should calculate the correct price with fruits and protein.");
    }

    
    @Test
    void testGetNumOfFruits() {
        assertEquals(3, smoothie.getNumOfFruits(), "getNumOfFruits should return the correct number of fruits.");
    }

    @Test
    void testSetNumOfFruits() {
        smoothie.setNumOfFruits(5);
        assertEquals(5, smoothie.getNumOfFruits(), "setNumOfFruits should update the number of fruits correctly.");
    }

    @Test
    void testIsAddProtein() {
        assertTrue(smoothie.isAddProtein(), "isAddProtein should return true when protein is added.");
    }

    @Test
    void testSetAddProtein() {
        smoothie.setAddProtein(false);
        assertFalse(smoothie.isAddProtein(), "setAddProtein should update the protein addition status correctly.");
    }
}
