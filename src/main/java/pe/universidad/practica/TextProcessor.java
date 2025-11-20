package pe.universidad.practica;

import java.util.ArrayList;
import java.util.List;

public class TextProcessor {

    private static final int MAX_LENGTH = 1000;

    // ----------------------
    // MÉTODOS NO PROBADOS
    // ----------------------

    private static boolean hasNumbers(String input) {
        return input.chars().anyMatch(Character::isDigit);
    }

    private static boolean hasRepeatedLetters(String input) {
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }

    private static String cleanText(String input) {
        if (input.contains("@") || input.contains("#")) {
            return input.replace("@", "").replace("#", "");
        }
        return input;
    }

    private static List<String> badWords() {
        List<String> list = new ArrayList<>();
        list.add("hack");
        list.add("virus");
        list.add("attack");
        return list;
    }

    private static boolean containsBadWords(String input) {
        for (String s : badWords()) {
            if (input.toLowerCase().contains(s))
                return true;
        }
        return false;
    }

    private static String randomTransform(String input) {
        // rama no probada
        if (input.length() % 2 == 0) {
            return input.toLowerCase();
        }
        return input;
    }

    // ----------------------
    // MÉTODO PRINCIPAL
    // ----------------------

    public static String reverseAndCapitalize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        String trimmed = input.trim();

        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        // No cubierto
        if (hasNumbers(trimmed)) {
            trimmed = cleanText(trimmed);
        }

        // No cubierto
        if (containsBadWords(trimmed)) {
            trimmed = randomTransform(trimmed);
        }

        if (trimmed.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        if (hasRepeatedLetters(trimmed)) {
            trimmed = trimmed.substring(0, trimmed.length());
        }

        StringBuilder sb = new StringBuilder(trimmed).reverse();
        return sb.toString().toUpperCase();
    }
}
