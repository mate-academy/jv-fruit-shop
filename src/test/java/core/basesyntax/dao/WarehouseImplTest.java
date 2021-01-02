package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WarehouseImplTest {

    @Test
    public void testAddFruit() {
        WarehouseImpl warehouseImpl = new WarehouseImpl();
        warehouseImpl.addFruit("Fruit", 10);
        assertEquals(1, warehouseImpl.getListFruits().size());
    }

    @Test
    public void testAddFruit2() {
        WarehouseImpl warehouseImpl1 = new WarehouseImpl();
        warehouseImpl1.addFruit("Fruit", 2);
        warehouseImpl1.addFruit("Fruit", 1);
        warehouseImpl1.addFruit("Fruit", 2);
        warehouseImpl1.addFruit("Apple", 2);
        assertEquals(5, warehouseImpl1.getAmountOfFruit("Fruit"));
        assertEquals(2, warehouseImpl1.getAmountOfFruit("Apple"));
        assertEquals(2, warehouseImpl1.getListFruits().size());
    }

    @Test
    public void testReplace() {
        WarehouseImpl warehouseImpl2 = new WarehouseImpl();
        warehouseImpl2.addFruit("Fruit", 2);
        warehouseImpl2.replace("Fruit", 10);
        assertEquals(10, warehouseImpl2.getAmountOfFruit("Fruit"));
    }

    @Test
    public void testGetAmountOfFruit() {
        WarehouseImpl warehouseImpl3 = new WarehouseImpl();
        warehouseImpl3.addFruit("Fruit", 2);
        warehouseImpl3.addFruit("Fruit", 10);
        assertEquals(12, warehouseImpl3.getAmountOfFruit("Fruit"));
        assertEquals(0, warehouseImpl3.getAmountOfFruit("Apple"));
    }
}

