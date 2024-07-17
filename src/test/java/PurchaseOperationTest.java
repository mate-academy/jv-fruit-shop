import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.PurchaseOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseOperationTest {
    private Storage storage;

    @BeforeEach
    public void setUp() {
        storage = new Storage();
        storage.addFruit("banana", 50);
    }

    @Test
    public void testPurchaseOperation() {
        FruitTransaction transaction = new FruitTransaction(FruitTransaction.Operation.PURCHASE,
                "banana", 10);
        new PurchaseOperation().handle(transaction, storage);
        assertEquals((Integer) 40, storage.getFruitQuantities().get("banana"));
    }
}
