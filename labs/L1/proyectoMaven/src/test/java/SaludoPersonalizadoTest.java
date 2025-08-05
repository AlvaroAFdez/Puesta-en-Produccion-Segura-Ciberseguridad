import org.junit.Test;
import static org.junit.Assert.*;

public class SaludoPersonalizadoTest {

    @Test
    public void testSaludoConNombre() {
        
        SaludoPersonalizado saludo = new SaludoPersonalizado("Juan");

        assertEquals("¡Hola, Juan!", saludo.getSaludo());
    }

    @Test
    public void testSaludoConOtroNombre() {
        
        SaludoPersonalizado saludo = new SaludoPersonalizado("Paco");

        assertEquals("¡Hola, Paco!", saludo.getSaludo());
    }

    @Test
    public void testSaludoConNombreVacio() {

        SaludoPersonalizado saludo = new SaludoPersonalizado("");

        assertEquals("¡Hola, !", saludo.getSaludo());
    }
}
