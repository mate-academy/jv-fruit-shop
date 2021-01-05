package core.basesyntax.fruitoperation.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperationStrategyImplTest {
    private static OperationStrategy operationStrategy;
    private static Fruit apple;

    @BeforeClass
    public static void beforeClass() throws Exception {
        apple = new Fruit("apple");
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new OperationBalance());
        operationMap.put(Operations.P, new OperationPurchase());
        operationMap.put(Operations.R, new OperationReturn());
        operationMap.put(Operations.S, new OperationSupply());
        operationStrategy = new OperationStrategyImpl(operationMap);
    }

    @Before
    public void setUp() throws Exception {
        Storage.setFruits(new TreeMap<>());
    }

    @Test
    public void operationReturn_Ok() {
        operationStrategy.get(Operations.B).doOperation(apple, 20);
        operationStrategy.get(Operations.R).doOperation(apple, 10);
        Map<Fruit, Integer> fruits = Storage.getFruits();
        int actual = fruits.get(apple);
        Assert.assertEquals(30, actual);
    }

    @Test(expected = RuntimeException.class)
    public void operationReturn_notOk() {
        operationStrategy.get(Operations.R).doOperation(apple, 10);
    }

    @Test
    public void operationSupply_Ok() {
        operationStrategy.get(Operations.B).doOperation(apple, 20);
        operationStrategy.get(Operations.S).doOperation(apple, 10);
        Map<Fruit, Integer> fruits = Storage.getFruits();
        int actual = fruits.get(apple);
        Assert.assertEquals(30, actual);
    }

    @Test(expected = RuntimeException.class)
    public void operationSupply_notOk() {
        operationStrategy.get(Operations.S).doOperation(apple, 10);
    }

    @Test
    public void operationPurchase_Ok() {
        operationStrategy.get(Operations.B).doOperation(apple, 20);
        operationStrategy.get(Operations.P).doOperation(apple, 10);
        Map<Fruit, Integer> fruits = Storage.getFruits();
        int actual = fruits.get(apple);
        Assert.assertEquals(10, actual);
    }

    @Test(expected = RuntimeException.class)
    public void operationPurchase_notOk() {
        operationStrategy.get(Operations.B).doOperation(apple, 20);
        operationStrategy.get(Operations.P).doOperation(apple, 30);
    }

    @Test(expected = RuntimeException.class)
    public void operationPurchaseWithoutBalance_notOk() {
        operationStrategy.get(Operations.P).doOperation(apple, 30);
    }

    @Test
    public void operationBalance_Ok() {
        operationStrategy.get(Operations.B).doOperation(apple, 20);
        Map<Fruit, Integer> fruits = Storage.getFruits();
        int actual = fruits.get(apple);
        Assert.assertEquals(20, actual);
    }

    @Test(expected = RuntimeException.class)
    public void operationBalance_notOk() {
        operationStrategy.get(Operations.B).doOperation(apple, 20);
        operationStrategy.get(Operations.B).doOperation(apple, 20);
    }
}
