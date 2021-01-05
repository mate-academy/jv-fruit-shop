package core.basesyntax.model;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.impl.BalanceOperation;
import org.junit.Test;

public class BalanceOperationTest {
    private static final Warehouse<Fruit> WAREHOUSE = new Warehouse<>();

    @Test
    public void executeBalanceOperationTest() {
        BalanceOperation<Fruit> balanceOperation = new BalanceOperation<>(WAREHOUSE);
        balanceOperation.execute(new Fruit("test"), 10);
        assertEquals(1, WAREHOUSE.getStorage().size());
    }
}
