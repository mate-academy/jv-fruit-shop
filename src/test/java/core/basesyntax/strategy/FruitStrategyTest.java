package core.basesyntax.strategy;

import static org.junit.jupiter.api.Assertions.*;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.storage.Storage;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitStrategyTest {
    private FruitStrategy fruitStrategy;

    @BeforeEach
    void setUp() {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<Operation, OperationHandler> strategyMap = Map.of(
                Operation.BALANCE, new BalanceStrategy(fruitDao),
                Operation.PURCHASE, new DecreaseStrategy(fruitDao),
                Operation.SUPPLY, new IncreaseStrategy(fruitDao),
                Operation.RETURN, new IncreaseStrategy(fruitDao)
        );
        fruitStrategy = new FruitStrategy(strategyMap);
    }

    @Test
    void processData_validData_ok() {
        List<FruitTransaction> fruitTransactions = List.of(
                new FruitTransaction(Operation.BALANCE, "banana", 100),
                new FruitTransaction(Operation.BALANCE, "apple", 80),
                new FruitTransaction(Operation.PURCHASE, "banana", 10),
                new FruitTransaction(Operation.SUPPLY, "apple", 75),
                new FruitTransaction(Operation.RETURN, "banana", 5)
        );
        fruitStrategy.processData(fruitTransactions);
        Map<String, Integer> actual = Storage.STORAGE;
        Map<String, Integer> expected = Map.of("apple", 155,
                "banana", 95);
        assertEquals(expected, actual);
    }
}