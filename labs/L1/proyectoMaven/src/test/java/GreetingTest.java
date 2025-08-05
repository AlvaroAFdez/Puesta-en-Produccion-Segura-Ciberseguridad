import org.junit.Test;
import static org.junit.Assert.*;

public class GreetingTest {
    @Test
    public void testGetMessage() {
        Greeting greeting = new Greeting();
        assertEquals("Hello, World!", greeting.getMessage());
    }
}