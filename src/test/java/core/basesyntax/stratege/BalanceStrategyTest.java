package core.basesyntax.stratege;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BalanceStrategyTest {
    private static Map<Fruit, Integer> storage;
    private static OperationStrategy balanceStrategy;

    @BeforeClass
    public static void beforeClass() {
        storage = new HashMap<>();
        balanceStrategy = new BalanceStrategy();
    }

    @After
    public void tearDown() {
        Storage.fruitsAndAmountsMap.clear();
        storage.clear();
    }

    @Test
    public void doOperationWithBalanceStrategy_Ok() {
        storage.put(new Fruit("Apple"), 100);
        storage.put(new Fruit("Orange"), 200);
        balanceStrategy.doOperation(new TransactionDto(Operation.BALANCE,
                new Fruit("Apple"), 100));
        balanceStrategy.doOperation(new TransactionDto(Operation.BALANCE,
                new Fruit("Orange"), 200));
        Set<Map.Entry<Fruit, Integer>> expected = storage.entrySet();
        Set<Map.Entry<Fruit, Integer>> actual = Storage.fruitsAndAmountsMap.entrySet();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doOperationWithOperationWhichNotConsists_NotOk() {
        balanceStrategy.doOperation(new TransactionDto(Operation.getOperationByLetter("a"),
                new Fruit("Apple"), 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void doOperationWithNegativeQuantity_NotOk() {
        balanceStrategy.doOperation(new TransactionDto(Operation.BALANCE,
                new Fruit("Apple"), -100));
    }
}
