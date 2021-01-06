package core.basesyntax.model;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Warehouse;
import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.strategy.PurchaseOperation;
import org.junit.After;
import org.junit.Test;

public class PurchaseOperationTest {
    private static final Fruit TEST_PRODUCT = new Fruit("test");
    private static final Integer TEST_AMOUNT = 10;
    private static final PurchaseOperation<Fruit> PURCHASE_OPERATION =
            new PurchaseOperation<>(Warehouse.getFruitStorage());

    @Test
    public void executePurchaseOperation_ok() {
        Warehouse.getFruitStorage().put(TEST_PRODUCT, TEST_AMOUNT);
        PURCHASE_OPERATION.execute(TEST_PRODUCT, TEST_AMOUNT);
        assertEquals(1, Warehouse.getFruitStorage().size());
        assertEquals(Integer.valueOf(0), Warehouse.getFruitStorage().get(TEST_PRODUCT));
    }

    @Test(expected = InvalidOperationException.class)
    public void executePurchaseOperation_notOk() {
        PURCHASE_OPERATION.execute(TEST_PRODUCT, TEST_AMOUNT);
    }

    @After
    public void tearDown() {
        Warehouse.getFruitStorage().clear();
    }
}
