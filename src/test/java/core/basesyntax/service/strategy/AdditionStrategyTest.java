package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;

public class AdditionStrategyTest {
    private static AdditionStrategy strategy;
    private static final Fruit ORANGE = new Fruit("orange");
    private static final Fruit APPLE = new Fruit("apple");
    private static final Fruit LIME = new Fruit("lime");

    @Before
    public void setUp() throws Exception {
        strategy = new AdditionStrategy();
        Storage.balance = new HashMap<>();
        Storage.balance.put(ORANGE, 100);
        Storage.balance.put(APPLE, 150);
        Storage.balance.put(LIME, 200);
    }

    @Test
    public void additionWithBalanceOperation_Ok() {
        Integer expectedLimeBalance = 50;
        strategy.apply(new Transaction(Operation.BALANCE, LIME, 50));
        Assert.assertEquals(expectedLimeBalance, Storage.balance.get(LIME));
        Integer expectedAppleBalance = 100;
        strategy.apply(new Transaction(Operation.BALANCE, APPLE, 100));
        Assert.assertEquals(expectedAppleBalance, Storage.balance.get(APPLE));
        Integer expectedOrangeBalance = 150;
        strategy.apply(new Transaction(Operation.BALANCE, ORANGE, 150));
        Assert.assertEquals(expectedOrangeBalance, Storage.balance.get(ORANGE));
    }

    @Test
    public void additionWithSupplyOperation_Ok() {
        Integer expectedLimeBalance = 350;
        strategy.apply(new Transaction(Operation.SUPPLY, LIME, 150));
        Assert.assertEquals(expectedLimeBalance, Storage.balance.get(LIME));
        Integer expectedAppleBalance = 250;
        strategy.apply(new Transaction(Operation.SUPPLY, APPLE, 100));
        Assert.assertEquals(expectedAppleBalance, Storage.balance.get(APPLE));
        Integer expectedOrangeBalance = 250;
        strategy.apply(new Transaction(Operation.SUPPLY, ORANGE, 150));
        Assert.assertEquals(expectedOrangeBalance, Storage.balance.get(ORANGE));
    }

    @Test
    public void additionWithReturnOperation_Ok() {
        Integer expectedLimeBalance = 205;
        strategy.apply(new Transaction(Operation.RETURN, LIME, 5));
        Assert.assertEquals(expectedLimeBalance, Storage.balance.get(LIME));
        Integer expectedAppleBalance = 160;
        strategy.apply(new Transaction(Operation.RETURN, APPLE, 10));
        Assert.assertEquals(expectedAppleBalance, Storage.balance.get(APPLE));
        Integer expectedOrangeBalance = 150;
        strategy.apply(new Transaction(Operation.RETURN, ORANGE, 50));
        Assert.assertEquals(expectedOrangeBalance, Storage.balance.get(ORANGE));
    }

    @Test(expected = RuntimeException.class)
    public void additionWithNegativeQuantity_Ok() {
        strategy.apply(new Transaction(Operation.BALANCE, LIME, -5));
        strategy.apply(new Transaction(Operation.SUPPLY, APPLE, -10));
    }

    @After
    public void tearDown() throws Exception {
        Storage.balance = new HashMap<>();
    }
}
