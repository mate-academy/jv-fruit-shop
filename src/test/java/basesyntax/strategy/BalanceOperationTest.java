package basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import basesyntax.db.Storage;
import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalanceOperationTest {

    private OperationHandler handler;

    @BeforeEach
    void setUp() {
        handler = new BalanceOperation();
        Storage.clear();
    }

    @Test
    void apply_validBalance_ok() {
        FruitTransaction transaction =
                new FruitTransaction(
                        FruitTransaction.Operation.BALANCE,
                        "banana",
                        100
                );

        handler.apply(transaction);

        assertEquals(100, Storage.getFruits().get("banana"));
    }
}
