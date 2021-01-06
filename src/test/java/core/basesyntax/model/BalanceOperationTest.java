package core.basesyntax.model;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.strategy.BalanceOperation;
import org.junit.After;
import org.junit.Test;

public class BalanceOperationTest {
    private static final Fruit TEST_PRODUCT = new Fruit("test");
    private static final Integer TEST_AMOUNT = 10;

    @Test
    public void executeBalanceOperationTest() {
        BalanceOperation<Fruit> balanceOperation =
                new BalanceOperation<>(Warehouse.getFruitStorage());
        balanceOperation.execute(TEST_PRODUCT, TEST_AMOUNT);
        assertEquals(1, Warehouse.getFruitStorage().size());
    }

    @After
    public void tearDown() {
        Warehouse.getFruitStorage().clear();
    }
}
