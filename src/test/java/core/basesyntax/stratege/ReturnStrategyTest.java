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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReturnStrategyTest {
    private static Map<Fruit, Integer> storage;
    private static OperationStrategy returnStrategy;

    @BeforeClass
    public static void beforeClass() {
        storage = new HashMap<>();
        returnStrategy = new ReturnStrategy();
    }

    @Before
    public void setUp() {
        Storage.fruitsAndAmountsMap.put(new Fruit("Apple"), 100);
        Storage.fruitsAndAmountsMap.put(new Fruit("Orange"), 200);
    }

    @After
    public void tearDown() {
        Storage.fruitsAndAmountsMap.clear();
        storage.clear();
    }

    @Test
    public void doOperationWithFruitWhichConsist_Ok() {
        storage.put(new Fruit("Apple"), 120);
        storage.put(new Fruit("Orange"), 250);
        returnStrategy.doOperation(new TransactionDto(Operation.RETURN,
                new Fruit("Apple"), 20));
        returnStrategy.doOperation(new TransactionDto(Operation.RETURN,
                new Fruit("Orange"), 50));
        Set<Map.Entry<Fruit, Integer>> expected = storage.entrySet();
        Set<Map.Entry<Fruit, Integer>> actual = Storage.fruitsAndAmountsMap.entrySet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void doOperationWithFruitWhichNotConsists_Ok() {
        storage.put(new Fruit("Apple"), 100);
        storage.put(new Fruit("Orange"), 200);
        storage.put(new Fruit("Agave"), 100);
        returnStrategy.doOperation(new TransactionDto(Operation.RETURN,
                new Fruit("Agave"), 100));
        Set<Map.Entry<Fruit, Integer>> expected = storage.entrySet();
        Set<Map.Entry<Fruit, Integer>> actual = Storage.fruitsAndAmountsMap.entrySet();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doOperationWithNegativeQuantity_NotOk() {
        returnStrategy.doOperation(new TransactionDto(Operation.RETURN,
                new Fruit("Apple"), -100));
    }
}
