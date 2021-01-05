package core.basesyntax.model;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.impl.PurchaseOperation;
import org.junit.Test;

public class PurchaseOperationTest {
    private static final Warehouse<Fruit> WAREHOUSE = new Warehouse<>();

    @Test
    public void executeBalanceOperationTest() {
        PurchaseOperation<Fruit> purchaseOperation = new PurchaseOperation<>(WAREHOUSE);
        purchaseOperation.execute(new Fruit("test"), 10);
        assertEquals(1, WAREHOUSE.getStorage().size());
    }
}
