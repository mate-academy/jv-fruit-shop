package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.strategy.AdditionStrategy;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.SubtractionStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static Map<Operation, OperationStrategy> strategyMap;
    private static FruitServiceImpl fruitService;
    private static final Fruit ORANGE = new Fruit("orange");
    private static final Fruit APPLE = new Fruit("apple");

    @BeforeClass
    public static void beforeClass() {
        strategyMap = new HashMap<>();
        strategyMap.put(Operation.BALANCE, new AdditionStrategy());
        strategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        strategyMap.put(Operation.RETURN, new AdditionStrategy());
        strategyMap.put(Operation.PURCHASE, new SubtractionStrategy());
        fruitService = new FruitServiceImpl(strategyMap);
    }

    @Before
    public void setUp() {
        Storage.balance = new HashMap<>();
    }

    @Test
    public void applyOperationWithOneFruit_Ok() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(Operation.BALANCE, ORANGE, 100));
        transactions.add(new Transaction(Operation.SUPPLY, ORANGE, 150));
        transactions.add(new Transaction(Operation.PURCHASE, ORANGE, 50));
        transactions.add(new Transaction(Operation.RETURN, ORANGE, 10));
        fruitService.applyOperation(transactions);
        Integer expected = 210;
        Assert.assertEquals(Storage.balance.get(ORANGE), expected);
    }

    @Test
    public void applyOperationWithTwoFruits_Ok() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(Operation.BALANCE, ORANGE, 210));
        transactions.add(new Transaction(Operation.BALANCE, APPLE, 200));
        transactions.add(new Transaction(Operation.SUPPLY, ORANGE, 150));
        transactions.add(new Transaction(Operation.PURCHASE, APPLE, 50));
        transactions.add(new Transaction(Operation.PURCHASE, ORANGE, 50));
        transactions.add(new Transaction(Operation.SUPPLY, APPLE, 300));
        transactions.add(new Transaction(Operation.RETURN, ORANGE, 10));
        transactions.add(new Transaction(Operation.RETURN, APPLE, 15));
        fruitService.applyOperation(transactions);
        Integer expectedForOrange = 320;
        Assert.assertEquals(Storage.balance.get(ORANGE), expectedForOrange);
        Integer expectedForApple = 465;
        Assert.assertEquals(Storage.balance.get(APPLE), expectedForApple);
    }

    @After
    public void tearDown() {
        Storage.balance = new HashMap<>();
    }

    @AfterClass
    public static void afterClass() {
        strategyMap = new HashMap<>();
        fruitService = null;
    }
}
