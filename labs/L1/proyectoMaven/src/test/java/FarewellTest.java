import org.junit.Test;
import static org.junit.Assert.*;

public class FarewellTest {
    @Test
    public void testGetMessage() {
        Farewell farewell = new Farewell();
        assertEquals("Goodbye, World!", farewell.getMessage());
    }
}