package pe.universidad.practica;

import java.util.regex.Pattern;

public class PasswordValidator {

    private static final int MIN = 8;
    private static final int MAX = 64;

    private static final String SPECIALS = "!@#$%^&*()_\\-+={}\\[\\]|\\\\:;\"'<>.,\\?/";

    private static final Pattern VALID_PATTERN = Pattern.compile(
            "^(?=.{8,64}$)"
                    + "(?=.*[A-Z])"
                    + "(?=.*[a-z])"
                    + "(?=.*\\d)"
                    + "(?=.*[" + SPECIALS + "])"
                    + "(?!.*\\s{2,})"
                    + "(?!^\\s)"
                    + "(?!.*\\s$)"
                    + "[\\p{Alnum}" + SPECIALS + "\\s]+$");

    // Método agregado que NO será probado
    private static boolean hasOnlyValidChars(String password) {
        return password.chars().allMatch(c -> c > 32 && c < 127);
    }

    public static boolean isValid(String password) {

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        // Condición adicional que NO será probada por las 6 pruebas
        if (!hasOnlyValidChars(password)) {
            return false;
        }

        if (password.length() < MIN || password.length() > MAX) {
            return false;
        }

        return VALID_PATTERN.matcher(password).matches();
    }
}
