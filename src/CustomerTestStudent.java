import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTestStudent {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe", 25);
    }

    @Test
    void testConstructor() {
        assertAll("Constructor should set name and age correctly",
            () -> assertEquals("John Doe", customer.getName(), "Name should be set by constructor."),
            () -> assertEquals(25, customer.getAge(), "Age should be set by constructor.")
        );
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", customer.getName(), "getName should return the correct name.");
    }

    @Test
    void testSetName() {
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName(), "setName should update the name correctly.");
    }

    @Test
    void testGetAge() {
        assertEquals(25, customer.getAge(), "getAge should return the correct age.");
    }

    @Test
    void testSetAge() {
        customer.setAge(30);
        assertEquals(30, customer.getAge(), "setAge should update the age correctly.");
    }

    @Test
    void testToString() {
        String expectedString = "Customer [Name=John Doe, Age=25]";
        assertEquals(expectedString, customer.toString(), "toString should return the correct string representation.");
    }
}
