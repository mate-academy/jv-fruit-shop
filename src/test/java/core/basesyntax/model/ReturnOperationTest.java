package core.basesyntax.model;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Warehouse;
import core.basesyntax.model.entities.Fruit;
import core.basesyntax.model.impl.ReturnOperation;
import org.junit.Test;

public class ReturnOperationTest {
    private static final Warehouse<Fruit> WAREHOUSE = new Warehouse<>();

    @Test
    public void executeBalanceOperationTest() {
        ReturnOperation<Fruit> returnOperation = new ReturnOperation<>(WAREHOUSE);
        returnOperation.execute(new Fruit("test"), 10);
        assertEquals(1, WAREHOUSE.getStorage().size());
    }
}
