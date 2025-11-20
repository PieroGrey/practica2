package pe.universidad.practica;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    public void testNullEmailThrows() {
        Email e = new Email();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> e.isValidEmail(null));
        assertEquals("El correo no puede ser nulo o vacío", ex.getMessage());
    }

    @Test
    public void testBasicValidEmail() {
        Email e = new Email();
        assertTrue(e.isValidEmail("persona@correo.com"));
    }

    @Test
    public void testEmailWithoutArroba() {
        Email e = new Email();
        assertFalse(e.isValidEmail("correo.com"));
    }

    @Test
    public void testEmailEndsWithSpace() {
        Email e = new Email();
        assertFalse(e.isValidEmail("alex@dominio.com "));
    }

    @Test
    public void testEmailConsecutivosEspacios() {
        Email e = new Email();
        assertFalse(e.isValidEmail("peru  2025@dominio.com"));
    }

    @Test
    public void testVeryShortEmail() {
        Email e = new Email();
        assertFalse(e.isValidEmail("a@b.c"));
    }
}
