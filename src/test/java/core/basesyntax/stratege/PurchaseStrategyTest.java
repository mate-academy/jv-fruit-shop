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

public class PurchaseStrategyTest {
    private static Map<Fruit, Integer> storage;
    private static OperationStrategy purchaseStrategy;

    @BeforeClass
    public static void beforeClass() {
        storage = new HashMap<>();
        purchaseStrategy = new PurchaseStrategy();
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
    public void doOperationWithPurchaseStrategy_Ok() {
        storage.put(new Fruit("Apple"), 20);
        storage.put(new Fruit("Orange"), 50);
        purchaseStrategy.doOperation(new TransactionDto(Operation.PURCHASE,
                new Fruit("Apple"), 80));
        purchaseStrategy.doOperation(new TransactionDto(Operation.PURCHASE,
                new Fruit("Orange"), 150));
        Set<Map.Entry<Fruit, Integer>> expected = storage.entrySet();
        Set<Map.Entry<Fruit, Integer>> actual = Storage.fruitsAndAmountsMap.entrySet();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doOperationWithPurchaseStrategyWithNegativeQuantity_NotOk() {
        purchaseStrategy.doOperation(new TransactionDto(Operation.PURCHASE,
                new Fruit("Apple"), -100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void doOperationWithPurchaseStrategyWhenFruitNotFound_NotOk() {
        purchaseStrategy.doOperation(new TransactionDto(Operation.PURCHASE,
                new Fruit("Agave"), 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void doOperationWithPurchaseStrategyWithMoreQuantityWhichConsist_NotOk() {
        purchaseStrategy.doOperation(new TransactionDto(Operation.PURCHASE,
                new Fruit("Apple"), 200));
    }
}
