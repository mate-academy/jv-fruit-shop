package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.storage.Storage;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecreaseStrategyTest {
    private OperationHandler operationHandler;

    @BeforeEach
    void setUp() {
        operationHandler = new DecreaseStrategy(new FruitDaoImpl());
    }

    @Test
    void apply_validInput_ok() {
        Storage.STORAGE.put("banana", 20);
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.PURCHASE, "banana", 10);
        operationHandler.apply(fruitTransaction);
        Map<String, Integer> expected = Map.of("banana", 10);
        Map<String, Integer> actual = Storage.STORAGE;
        assertEquals(expected, actual);
    }

    @Test
    void apply_invalidInput_notOk() {
        Storage.STORAGE.put("banana", 5);
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.PURCHASE, "banana", 10);
        assertThrows(IllegalArgumentException.class, () ->
                operationHandler.apply(fruitTransaction));
        operationHandler.apply(new FruitTransaction(Operation.PURCHASE, "banana", 2));
    }
}
