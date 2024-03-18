package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.storage.Storage;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IncreaseStrategyTest {
    private OperationHandler operationHandler;

    @BeforeEach
    void setUp() {
        operationHandler = new IncreaseStrategy(new FruitDaoImpl());
    }

    @AfterEach
    void tearDown() {
        Storage.STORAGE.clear();
    }

    @Test
    void apply_validInput_ok() {
        Storage.STORAGE.put("banana", 30);
        FruitTransaction transaction = new FruitTransaction(Operation.SUPPLY, "banana", 10);
        operationHandler.apply(transaction);
        Map<String, Integer> actual = Map.of("banana", 40);
        Map<String, Integer> expected = Storage.STORAGE;
        assertEquals(actual, expected);
    }
}
