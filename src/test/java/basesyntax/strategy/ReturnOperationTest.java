package basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import basesyntax.db.Storage;
import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReturnOperationTest {

    private OperationHandler handler;

    @BeforeEach
    void setUp() {
        handler = new ReturnOperation();
        Storage.clear();
        Storage.getFruits().put("banana", 10);
    }

    @Test
    void apply_validReturn_ok() {
        FruitTransaction transaction =
                new FruitTransaction(FruitTransaction.Operation.RETURN, "banana", 5);

        handler.apply(transaction);

        assertEquals(15, Storage.getFruits().get("banana"));
    }
}
