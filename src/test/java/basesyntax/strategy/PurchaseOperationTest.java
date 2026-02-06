package basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertThrows;

import basesyntax.db.Storage;
import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchaseOperationTest {

    private OperationHandler handler;

    @BeforeEach
    void setUp() {
        handler = new PurchaseOperation();
        Storage.clear();
        Storage.getFruits().put("banana", 5);
    }

    @Test
    void apply_notEnoughFruits_notOk() {
        FruitTransaction transaction =
                new FruitTransaction(
                        FruitTransaction.Operation.PURCHASE,
                        "banana",
                        10
                );

        assertThrows(RuntimeException.class,
                () -> handler.apply(transaction));
    }
}
