package pe.universidad.practica;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void testNullPasswordThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid(null);
        });
        assertEquals("La contraseña no puede ser nula o vacía", ex.getMessage());
    }

    @Test
    public void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
    }

    @Test
    public void testInvalidMissingRequirements() {
        assertFalse(PasswordValidator.isValid("nosecura")); 
    }

    @Test
    public void testTooShortPassword() {
        assertFalse(PasswordValidator.isValid("A1!a")); 
    }

    @Test
    public void testPasswordWithConsecutiveSpacesRejected() {
        assertFalse(PasswordValidator.isValid("Secure  123!")); 
    }

    @Test
    public void testEdgeMaxLength() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 60; i++) sb.append('a');
        String s = "A1!" + sb.toString();
        while (s.length() < 8) s += "a";
        assertTrue(PasswordValidator.isValid(s));
        // too long
        String tooLong = s + "a".repeat(64 - s.length() + 1);
        if (tooLong.length() > 64) assertFalse(PasswordValidator.isValid(tooLong));
    }
}
