package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.*;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalanceStrategyTest {
    private OperationHandler operationHandler;
    private FruitDao fruitDao;

    @BeforeEach
    void setUp() {
        operationHandler = new BalanceStrategy(new FruitDaoImpl());
        fruitDao = new FruitDaoImpl();
    }

    @Test
    void apply_validInput_ok() {
        FruitTransaction fruitTransaction = new FruitTransaction(Operation.BALANCE, "banana", 100);
        operationHandler.apply(fruitTransaction);
        Map<String, Integer> expected = Map.of(fruitTransaction.fruitName(),
                fruitTransaction.quantity());
        Map<String, Integer> actual = fruitDao.getFruits();
        assertEquals(expected, actual);
    }
}
