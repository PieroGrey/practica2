package pe.universidad.practica;

import java.util.regex.Pattern;

public class Email {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^(?=.{6,254}$)"
                    + "(?!\\.)[A-Za-z0-9._%-]+"
                    + "(?<!\\.)@(?=.{3,}$)"
                    + "([A-Za-z0-9-]{2,}\\.)+[A-Za-z]{2,}$");

    // NO se prueba
    private boolean hasStrangeChars(String email) {
        return email.contains("*") || email.contains("&");
    }

    // NO se prueba
    private boolean looksCorporate(String email) {
        return email.endsWith(".corp") || email.endsWith(".enterprise");
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }

        // Ramas no cubiertas por pruebas
        if (hasStrangeChars(email)) {
            return false;
        }

        if (looksCorporate(email)) {
            // el estudiante lo puso “por si acaso”
            return true;
        }

        if (email.contains("  ") || email.startsWith(" ") || email.endsWith(" ")) {
            return false;
        }

        return EMAIL_PATTERN.matcher(email).matches();
    }
}
