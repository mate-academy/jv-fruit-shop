package core.basesyntax.model;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.impl.SupplyOperation;
import org.junit.Test;

public class SupplyOperationTest {
    private static final Warehouse<Fruit> WAREHOUSE = new Warehouse<>();

    @Test
    public void executeBalanceOperationTest() {
        SupplyOperation<Fruit> supplyOperation = new SupplyOperation<>(WAREHOUSE);
        supplyOperation.execute(new Fruit("test"), 10);
        assertEquals(1, WAREHOUSE.getStorage().size());
    }
}
