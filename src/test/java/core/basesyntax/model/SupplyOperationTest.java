package core.basesyntax.model;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.strategy.SupplyOperation;
import org.junit.After;
import org.junit.Test;

public class SupplyOperationTest {
    private static final Fruit TEST_PRODUCT = new Fruit("test");
    private static final Integer TEST_AMOUNT = 10;

    @Test
    public void executeSupplyOperationTest() {
        SupplyOperation<Fruit> supplyOperation = new SupplyOperation<>(Warehouse.getFruitStorage());
        supplyOperation.execute(TEST_PRODUCT, TEST_AMOUNT);
        assertEquals(1, Warehouse.getFruitStorage().size());
        assertEquals(Integer.valueOf(10), Warehouse.getFruitStorage().get(TEST_PRODUCT));
    }

    @After
    public void tearDown() {
        Warehouse.getFruitStorage().clear();
    }
}
