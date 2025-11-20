package pe.universidad.practica;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    public void testBasicReverseAndCapitalize() {
        assertEquals("HOLA", TextProcessor.reverseAndCapitalize(" aloH "));
    }

    @Test
    public void testNullThrows() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize(null));
        assertEquals("El texto no puede ser nulo", ex.getMessage());
    }

    @Test
    public void testOnlySpacesThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize("   "));
    }

    @Test
    public void testLongTextThrows() {
        String t = "a".repeat(1001);
        assertThrows(IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize(t));
    }

    @Test
    public void testSimpleWord() {
        assertEquals("ANA", TextProcessor.reverseAndCapitalize("ana"));
    }

    @Test
    public void testTrimEffect() {
        assertEquals("UREP", TextProcessor.reverseAndCapitalize(" peru "));
    }

}
