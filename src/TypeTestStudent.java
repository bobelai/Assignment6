import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TypeTestStudent {

    @Test
    void testTypeEnum() {
        assertEquals(3, Type.values().length, "There should be 3 types in the Type enum.");
        assertEquals(Type.COFFEE, Type.valueOf("COFFEE"), "COFFEE should exist in Type enum.");
        assertEquals(Type.SMOOTHIE, Type.valueOf("SMOOTHIE"), "SMOOTHIE should exist in Type enum.");
        assertEquals(Type.ALCOHOL, Type.valueOf("ALCOHOL"), "ALCOHOL should exist in Type enum.");
    }
}
