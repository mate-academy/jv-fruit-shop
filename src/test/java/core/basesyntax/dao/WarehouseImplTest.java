package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import org.junit.Test;

public class WarehouseImplTest {

    @Test
    public void testAddFruit() {
        WarehouseImpl warehouseImpl = new WarehouseImpl();
        warehouseImpl.addItem(new Fruit("Fruit"), 10);
        assertEquals(1, warehouseImpl.getListItems().size());
    }

    @Test
    public void testAddFruit2() {
        WarehouseImpl warehouseImpl1 = new WarehouseImpl();
        warehouseImpl1.addItem(new Fruit("Fruit"), 2);
        warehouseImpl1.addItem(new Fruit("Fruit"), 1);
        warehouseImpl1.addItem(new Fruit("Fruit"), 2);
        warehouseImpl1.addItem(new Fruit("Apple"), 2);
        assertEquals(15, warehouseImpl1.getAmountOfItem(new Fruit("Fruit")));
        assertEquals(2, warehouseImpl1.getAmountOfItem(new Fruit("Apple")));
        assertEquals(2, warehouseImpl1.getListItems().size());
    }

    @Test
    public void testReplace() {
        WarehouseImpl warehouseImpl2 = new WarehouseImpl();
        warehouseImpl2.addItem(new Fruit("Fruit"), 2);
        warehouseImpl2.replace(new Fruit("Fruit"), 10);
        assertEquals(10, warehouseImpl2.getAmountOfItem(new Fruit("Fruit")));
    }

    @Test
    public void testGetAmountOfFruit() {
        WarehouseImpl warehouseImpl3 = new WarehouseImpl();
        warehouseImpl3.addItem(new Fruit("Pineapple"), 2);
        warehouseImpl3.addItem(new Fruit("Pineapple"), 10);
        assertEquals(12, warehouseImpl3.getAmountOfItem(new Fruit("Pineapple")));
        assertEquals(0, warehouseImpl3.getAmountOfItem(new Fruit("Orange")));
    }
}

