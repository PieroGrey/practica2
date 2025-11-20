package pe.universidad.practica;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    @Test
    public void testAddValidItem() {
        InventoryManager m = new InventoryManager();
        m.addItem("Cables", 5);
        assertEquals(5, m.getQuantity("Cables"));
    }

    @Test
    public void testAddInvalidQuantityThrows() {
        InventoryManager m = new InventoryManager();
        assertThrows(IllegalArgumentException.class, () -> m.addItem("USB", -1));
    }

    @Test
    public void testAddEmptyNameThrows() {
        InventoryManager m = new InventoryManager();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> m.addItem(" ", 2));
        assertEquals("El nombre del producto no puede estar vacío", ex.getMessage());
    }

    @Test
    public void testExistingItemAccumulates() {
        InventoryManager m = new InventoryManager();
        m.addItem("Mouse", 2);
        m.addItem("Mouse", 3);
        assertEquals(5, m.getQuantity("Mouse"));
    }

    @Test
    public void testContainsItem() {
        InventoryManager m = new InventoryManager();
        m.addItem("Laptop", 1);
        assertTrue(m.contains("Laptop"));
    }

    @Test
    public void testGetUnknownItemIsZero() {
        InventoryManager m = new InventoryManager();
        assertEquals(0, m.getQuantity("NoExiste"));
    }
}
