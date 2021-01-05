package core.basesyntax.service;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static FruitService fruitService;

    @BeforeClass
    public static void initialization() {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());
        fruitService = new FruitServiceImpl(operationStrategyMap);
    }

    @Before
    public void clearStorage() {
        Storage.storage.clear();
    }

    @Test
    public void applyOperations_correctValue_ok() {
        fruitService.applyOperations(List.of(
                new TransactionDto(new Fruit("banana"), 100, Operation.BALANCE),
                new TransactionDto(new Fruit("banana"), 50, Operation.SUPPLY),
                new TransactionDto(new Fruit("banana"), 20, Operation.PURCHASE)));
        Assert.assertEquals(Storage.storage.get(new Fruit("banana")), Integer.valueOf(130));
    }

    @Test(expected = RuntimeException.class)
    public void applyOperations_nullValue_notOk() {
        fruitService.applyOperations(null);
    }

    @Test
    public void getFruitReport_emptyStorage_ok() {
        Assert.assertTrue(Storage.storage.isEmpty());
    }

    @Test
    public void getFruitReport_twoValue_ok() {
        Storage.storage.put(new Fruit("banana"), 100);
        Storage.storage.put(new Fruit("apple"), 50);
        Assert.assertEquals(2, fruitService.getFruitReport().size());
    }
}
