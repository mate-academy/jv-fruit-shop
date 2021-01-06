package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReduceStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static List<TransactionDto> expectedTransactionDtos;
    private static FruitService fruitService;

    @After
    public void clear() {
        Storage.fruits.clear();
    }

    @BeforeClass
    public static void setUp() {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReduceStrategy());

        expectedTransactionDtos = new ArrayList<>();
        expectedTransactionDtos.add(new TransactionDto(Operation.BALANCE,
                new Fruit("banana"), 20));
        expectedTransactionDtos.add(new TransactionDto(Operation.BALANCE,
                new Fruit("apple"), 100));
        expectedTransactionDtos.add(new TransactionDto(Operation.SUPPLY,
                new Fruit("banana"), 100));
        expectedTransactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 13));
        expectedTransactionDtos.add(new TransactionDto(Operation.RETURN,
                new Fruit("apple"), 10));
        expectedTransactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("apple"), 20));
        expectedTransactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 5));
        expectedTransactionDtos.add(new TransactionDto(Operation.SUPPLY,
                new Fruit("banana"), 50));

        fruitService = new FruitServiceImpl(operationStrategyMap);
    }

    @Test
    public void applyOperationOnFruitsDto() {
        Fruit apple = new Fruit("apple");
        Fruit banana = new Fruit("banana");
        fruitService.applyOperationoOnFruitsDto(expectedTransactionDtos);
        Assert.assertEquals(90, Storage.fruits.get(apple).intValue());
        Assert.assertEquals(152, Storage.fruits.get(banana).intValue());
    }

    @Test
    public void getReport_ok() {
        Storage.fruits.put(new Fruit("orange"), 50);
        Storage.fruits.put(new Fruit("cherry"), 20);
        Map<Fruit, Integer> actual = fruitService.getFruitsReport();
        Map<Fruit, Integer> expected = new HashMap<>();
        expected.put(new Fruit("orange"), 50);
        expected.put(new Fruit("cherry"), 20);
        Assert.assertEquals(expected, actual);
    }
}
