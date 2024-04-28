import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BevShopTestStudent {
    private BevShop bevShop;

    @BeforeEach
    void setUp() {
        bevShop = new BevShop();
    }

    @Test
    void testIsValidTime() {
        assertTrue(bevShop.isValidTime(9), "9 AM should be a valid order time.");
        assertFalse(bevShop.isValidTime(7), "7 AM should be an invalid order time.");
    }

    @Test
    void testGetMaxNumOfFruits() {
        assertEquals(5, bevShop.getMaxNumOfFruits(), "Maximum number of fruits should be 5.");
    }

    @Test
    void testGetMinAgeForAlcohol() {
        assertEquals(21, bevShop.getMinAgeForAlcohol(), "Minimum age for alcohol should be 21.");
    }

    @Test
    void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(6), "6 fruits should exceed the maximum fruit limit.");
        assertFalse(bevShop.isMaxFruit(5), "5 fruits should not exceed the maximum fruit limit.");
    }

    @Test
    void testIsEligibleForMore() {
        bevShop.startNewOrder(12, Day.MONDAY, "John Doe", 25);
        bevShop.processAlcoholOrder("Whiskey", Size.MEDIUM);
        assertTrue(bevShop.isEligibleForMore(), "Should be eligible for more alcohol drinks.");
        bevShop.processAlcoholOrder("Whiskey", Size.MEDIUM);
        bevShop.processAlcoholOrder("Whiskey", Size.MEDIUM);
        assertFalse(bevShop.isEligibleForMore(), "Should not be eligible for more alcohol drinks after 3.");
    }

    @Test
    void testStartNewOrder() {
        bevShop.startNewOrder(12, Day.MONDAY, "John Doe", 25);
        assertNotNull(bevShop.getCurrentOrder(), "New order should be started.");
    }

    @Test
    void testProcessOrders() {
        bevShop.startNewOrder(12, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.SMALL, false, true);
        bevShop.processSmoothieOrder("Berry", Size.LARGE, 3, true);
        assertEquals(2, bevShop.getCurrentOrder().getBeverages().size(), "There should be 2 beverages in the order.");
    }

    @Test
    void testFindOrder() {
        bevShop.startNewOrder(12, Day.MONDAY, "John Doe", 25);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        assertEquals(0, bevShop.findOrder(orderNo), "Order should be found at index 0.");
    }

    @Test
    void testTotalOrderPrice() {
        bevShop.startNewOrder(12, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.SMALL, false, true);
        assertEquals(bevShop.totalOrderPrice(bevShop.getCurrentOrder().getOrderNo()), bevShop.getCurrentOrder().calcOrderTotal(), "Total order price should match the calculated order total.");
    }

    @Test
    void testTotalMonthlySale() {
        bevShop.startNewOrder(12, Day.MONDAY, "John Doe", 25);
        bevShop.processCoffeeOrder("Latte", Size.SMALL, false, true);
        bevShop.startNewOrder(14, Day.TUESDAY, "Jane Doe", 22);
        bevShop.processSmoothieOrder("Berry", Size.LARGE, 3, true);
        assertTrue(bevShop.totalMonthlySale() > 0, "Total monthly sale should be greater than 0.");
    }

   
    }

