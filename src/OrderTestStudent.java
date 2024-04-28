import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTestStudent {
    Order orderOne, orderTwo, orderThree;

    @BeforeEach
    public void setUp() throws Exception {
        orderOne = new Order(9, Day.WEDNESDAY, new Customer("Alice", 30));
        orderTwo = new Order(15, Day.FRIDAY, new Customer("Bob", 35));
        orderThree = new Order(18, Day.SATURDAY, new Customer("Charlie", 28));
    }

    @AfterEach
    public void tearDown() throws Exception {
        orderOne = orderTwo = orderThree = null;
    }

    @Test
    public void testGetBeverage() {
        Coffee coffee = new Coffee("Espresso", Size.MEDIUM, true, true);
        Alcohol alcohol = new Alcohol("Whiskey", Size.LARGE, true);
        Smoothie smoothie1 = new Smoothie("Green Mix", Size.MEDIUM, 2, true);
        Smoothie smoothie2 = new Smoothie("Green Mix", Size.SMALL, 2, true);

        orderOne.addNewBeverage("Espresso", Size.MEDIUM, true, true);
        orderOne.addNewBeverage("Whiskey", Size.LARGE);
        orderOne.addNewBeverage("Green Mix", Size.MEDIUM, 2, true);

        assertTrue(orderOne.getBeverage(0).equals(coffee));
        assertTrue(orderOne.getBeverage(2).equals(smoothie1));
        assertFalse(orderOne.getBeverage(2).equals(smoothie2));
    }

    @Test
    public void testAddNewBeverage() throws NullPointerException {
        assertEquals(0, orderOne.getBeverages().size(), "Initially, order should have no items.");
        orderOne.addNewBeverage("Espresso", Size.MEDIUM, true, true);
        assertEquals(Type.COFFEE, orderOne.getBeverage(0).getType());
        orderOne.addNewBeverage("Whiskey", Size.LARGE);
        assertEquals(Type.ALCOHOL, orderOne.getBeverage(1).getType());
        orderOne.addNewBeverage("Green Mix", Size.MEDIUM, 2, true);
        assertEquals(Type.SMOOTHIE, orderOne.getBeverage(2).getType());
        assertEquals(3, orderOne.getBeverages().size(), "Order should have three beverages.");

        orderTwo.addNewBeverage("Green Mix", Size.MEDIUM, 3, false);
        assertEquals(Type.SMOOTHIE, orderTwo.getBeverage(0).getType());
        orderTwo.addNewBeverage("Whiskey", Size.LARGE);
        assertEquals(Type.ALCOHOL, orderTwo.getBeverage(1).getType());
        orderTwo.addNewBeverage("Espresso", Size.SMALL, false, true);
        assertEquals(Type.COFFEE, orderTwo.getBeverage(2).getType());
        assertEquals(3, orderTwo.getBeverages().size(), "Order should have three beverages.");
    }

    @Test
    public void testCalcOrderTotal() {
        orderOne.addNewBeverage("Espresso", Size.MEDIUM, true, true);
        orderOne.addNewBeverage("Whiskey", Size.LARGE);
        orderOne.addNewBeverage("Green Mix", Size.MEDIUM, 2, true);
        orderTwo.addNewBeverage("Espresso", Size.SMALL, false, true);
        orderTwo.addNewBeverage("Whiskey", Size.LARGE);
        orderTwo.addNewBeverage("Green Mix", Size.MEDIUM, 3, false);
       
    }
}
