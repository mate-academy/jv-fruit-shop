package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WarehouseImplTest {

    @Test
    public void testAddFruit() {
        WarehouseImpl warehouseImpl = new WarehouseImpl();
        warehouseImpl.addItem("Fruit", 10);
        assertEquals(1, warehouseImpl.getListItems().size());
    }

    @Test
    public void testAddFruit2() {
        WarehouseImpl warehouseImpl1 = new WarehouseImpl();
        warehouseImpl1.addItem("Fruit", 2);
        warehouseImpl1.addItem("Fruit", 1);
        warehouseImpl1.addItem("Fruit", 2);
        warehouseImpl1.addItem("Apple", 2);
        assertEquals(5, warehouseImpl1.getAmountOfItem("Fruit"));
        assertEquals(2, warehouseImpl1.getAmountOfItem("Apple"));
        assertEquals(2, warehouseImpl1.getListItems().size());
    }

    @Test
    public void testReplace() {
        WarehouseImpl warehouseImpl2 = new WarehouseImpl();
        warehouseImpl2.addItem("Fruit", 2);
        warehouseImpl2.replace("Fruit", 10);
        assertEquals(10, warehouseImpl2.getAmountOfItem("Fruit"));
    }

    @Test
    public void testGetAmountOfFruit() {
        WarehouseImpl warehouseImpl3 = new WarehouseImpl();
        warehouseImpl3.addItem("Fruit", 2);
        warehouseImpl3.addItem("Fruit", 10);
        assertEquals(12, warehouseImpl3.getAmountOfItem("Fruit"));
        assertEquals(0, warehouseImpl3.getAmountOfItem("Apple"));
    }
}

