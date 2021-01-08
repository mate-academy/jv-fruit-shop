package core.basesyntax.model;

import core.basesyntax.database.Storage;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.Operations;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperationStrategyImplTest {
    private static OperationStrategy operationStrategy;
    private static Fruit banana;

    @BeforeClass
    public static void beforeClass() {
        banana = new Fruit("banana");
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.BALANCE, new BalanceOperation());
        operationMap.put(Operations.PURCHASE, new PurchaseOperation());
        operationMap.put(Operations.RETURN, new ReturnOperation());
        operationMap.put(Operations.SUPPLY, new SupplyOperation());
        operationStrategy = new OperationStrategyImpl(operationMap);
    }

    @Before
    public void setUp() {
        Storage.setFruitsMap(new TreeMap<>());
    }

    @Test
    public void returnOperation_Ok() {
        operationStrategy.get(Operations.BALANCE).doOperation(banana, 25);
        operationStrategy.get(Operations.RETURN).doOperation(banana, 15);
        Map<Fruit, Integer> fruits = Storage.getFruitsMap();
        int actual = fruits.get(banana);
        Assert.assertEquals(40, actual);
    }

    @Test(expected = RuntimeException.class)
    public void returnOperation_notOk() {
        operationStrategy.get(Operations.RETURN).doOperation(banana, 15);
    }

    @Test
    public void supplyOperation_Ok() {
        operationStrategy.get(Operations.BALANCE).doOperation(banana, 25);
        operationStrategy.get(Operations.SUPPLY).doOperation(banana, 15);
        Map<Fruit, Integer> fruits = Storage.getFruitsMap();
        int actual = fruits.get(banana);
        Assert.assertEquals(40, actual);
    }

    @Test(expected = RuntimeException.class)
    public void supplyOperation_notOk() {
        operationStrategy.get(Operations.SUPPLY).doOperation(banana, 15);
    }

    @Test
    public void purchaseOperation_Ok() {
        operationStrategy.get(Operations.BALANCE).doOperation(banana, 25);
        operationStrategy.get(Operations.PURCHASE).doOperation(banana, 15);
        Map<Fruit, Integer> fruits = Storage.getFruitsMap();
        int actual = fruits.get(banana);
        Assert.assertEquals(10, actual);
    }

    @Test(expected = RuntimeException.class)
    public void purchaseOperation_notOk() {
        operationStrategy.get(Operations.BALANCE).doOperation(banana, 25);
        operationStrategy.get(Operations.PURCHASE).doOperation(banana, 35);
    }

    @Test(expected = RuntimeException.class)
    public void purchaseOperationUnbalanced_notOk() {
        operationStrategy.get(Operations.PURCHASE).doOperation(banana, 35);
    }

    @Test
    public void balanceOperation_Ok() {
        operationStrategy.get(Operations.BALANCE).doOperation(banana, 25);
        Map<Fruit, Integer> fruits = Storage.getFruitsMap();
        int actual = fruits.get(banana);
        Assert.assertEquals(25, actual);
    }

    @Test(expected = RuntimeException.class)
    public void balanceOperation_notOk() {
        operationStrategy.get(Operations.BALANCE).doOperation(banana, 25);
        operationStrategy.get(Operations.BALANCE).doOperation(banana, 25);
    }
}
