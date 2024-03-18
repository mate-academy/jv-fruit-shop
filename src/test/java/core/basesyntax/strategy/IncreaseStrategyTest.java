package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.storage.FruitStorage;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IncreaseStrategyTest {
    private static Strategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new IncreaseStrategy(new FruitDaoImpl());
    }

    @AfterEach
    void tearDown() {
        FruitStorage.getFruits().clear();
    }

    @Test
    void apply_validInput_ok() {
        FruitStorage.getFruits().put("banana", 30);
        FruitTransaction transaction = new FruitTransaction(Operation.SUPPLY, "banana", 10);
        strategy.apply(transaction);
        Map<String, Integer> actual = Map.of("banana", 40);
        Map<String, Integer> expected = FruitStorage.getFruits();
        assertEquals(actual, expected);
    }
}
