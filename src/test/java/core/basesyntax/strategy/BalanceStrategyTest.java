package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.*;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.storage.FruitStorage;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalanceStrategyTest {
    private static Strategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new BalanceStrategy(new FruitDaoImpl());
    }

    @AfterEach
    void tearDown() {
        FruitStorage.getFruits().clear();
    }

    @Test
    void apply_validInput_ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.BALANCE, "banana", 100);
        strategy.apply(fruitTransaction);
        Map<String, Integer> actual = Map.of(fruitTransaction.fruit(), fruitTransaction.quantity());
        Map<String, Integer> expected = FruitStorage.getFruits();
        assertEquals(expected, actual);
    }
}