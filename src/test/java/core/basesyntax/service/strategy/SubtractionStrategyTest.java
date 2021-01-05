package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import java.util.HashMap;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubtractionStrategyTest {
    private static SubtractionStrategy strategy;
    private static final Fruit ORANGE = new Fruit("orange");
    private static final Fruit APPLE = new Fruit("apple");
    private static final Fruit LIME = new Fruit("lime");

    @Before
    public void setUp() {
        strategy = new SubtractionStrategy();
        Storage.balance = new HashMap<>();
        Storage.balance.put(ORANGE, 100);
        Storage.balance.put(APPLE, 150);
        Storage.balance.put(LIME, 200);
    }

    @Test
    public void subtractionOperation_Ok() {
        Integer expectedLimeBalance = 150;
        strategy.apply(new Transaction(Operation.PURCHASE, LIME, 50));
        Assert.assertEquals(expectedLimeBalance, Storage.balance.get(LIME));
        Integer expectedAppleBalance = 50;
        strategy.apply(new Transaction(Operation.PURCHASE, APPLE, 100));
        Assert.assertEquals(expectedAppleBalance, Storage.balance.get(APPLE));
        Integer expectedOrangeBalance = 75;
        strategy.apply(new Transaction(Operation.PURCHASE, ORANGE, 25));
        Assert.assertEquals(expectedOrangeBalance, Storage.balance.get(ORANGE));
    }

    @Test(expected = RuntimeException.class)
    public void subtractionWithNegativeQuantity_Ok() {
        strategy.apply(new Transaction(Operation.PURCHASE, LIME, -5));
        strategy.apply(new Transaction(Operation.PURCHASE, APPLE, -10));
    }

    @Test(expected = RuntimeException.class)
    public void subtractionWithIncorrectQuantity_Ok() {
        strategy.apply(new Transaction(Operation.PURCHASE, LIME, 300));
        strategy.apply(new Transaction(Operation.PURCHASE, APPLE, 400));
    }

    @After
    public void tearDown() {
        Storage.balance = new HashMap<>();
    }
}
