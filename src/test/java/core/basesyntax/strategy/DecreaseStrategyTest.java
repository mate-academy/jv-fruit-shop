package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.*;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.storage.FruitStorage;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecreaseStrategyTest {
    private static Strategy strategy;

    @BeforeEach
    void setUp() {
        strategy = new DecreaseStrategy(new FruitDaoImpl());
    }

    @AfterEach
    void tearDown() {
        FruitStorage.getFruits().clear();
    }

    @Test
    void apply_validInput_ok() {
        FruitStorage.getFruits().put("banana", 20);
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.PURCHASE, "banana", 10);
        strategy.apply(fruitTransaction);
        Map<String, Integer> expected = Map.of("banana", 10);
        Map<String, Integer> actual = FruitStorage.getFruits();
        assertEquals(expected, actual);
    }

    @Test
    void apply_wrongQuantity_notOk() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.PURCHASE, "banana", 10);
        assertThrows(RuntimeException.class, () ->
                strategy.apply(fruitTransaction));
    }
}
