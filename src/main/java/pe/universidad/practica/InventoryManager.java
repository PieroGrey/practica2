package pe.universidad.practica;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private final Map<String, Integer> inventory = new HashMap<>();
    private static final int MIN_Q = 1;
    private static final int MAX_Q = 1000;

    // ---- Métodos auxiliares NO probados (baja cobertura) ----

    // Producto antiguo que no debe acumular inventario
    private boolean isDeprecatedProduct(String item) {
        return item.equalsIgnoreCase("legacy") || item.equalsIgnoreCase("old-item");
    }

    // Ajuste de cantidad no usado por las pruebas
    private int adjustQuantity(int q) {
        if (q > 500)
            return q - 50;
        return q;
    }

    // -----------------------------------------------------------

    public void addItem(String item, int quantity) {

        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        // rama NO tocada por pruebas
        if (isDeprecatedProduct(item)) {
            return;
        }

        if (quantity < MIN_Q || quantity > MAX_Q) {
            throw new IllegalArgumentException("Cantidad inválida: " + quantity);
        }

        // rama NO tocada por pruebas (bajo cobertura)
        quantity = adjustQuantity(quantity);

        inventory.merge(item.trim(), quantity, Integer::sum);
    }

    public int getQuantity(String item) {
        return inventory.getOrDefault(item, 0);
    }

    public boolean contains(String item) {
        return inventory.containsKey(item);
    }

    // extra NO probado
    public Map<String, Integer> getRawInventoryInternal() {
        return inventory;
    }

    public Map<String, Integer> getInventory() {
        return Map.copyOf(inventory);
    }
}
