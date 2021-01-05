package core.basesyntax.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReductionStrategyTest {
    public static AdditionalStrategy additionalStrategy;
    public static ReductionStrategy reductionStrategy;
    public static FruitService fruitService;
    public static List<TransactionDto> transactionDtos;
    public static Map<Operation, OperationStrategy> operationStrategyMap;

    @BeforeClass
    public static void beforeClass() throws Exception {
        additionalStrategy = new AdditionalStrategy();
        reductionStrategy = new ReductionStrategy();
        fruitService = new FruitServiceImpl(operationStrategyMap);
        transactionDtos = new ArrayList<>();
        operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionalStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionalStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionalStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());
        transactionDtos.add(new TransactionDto(Operation.BALANCE,
                new Fruit("banana"), 20));
        transactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 10));
        Storage.fruits.removeAll(Storage.fruits);
    }

    @Test
    public void subtraction_Ok() {
        additionalStrategy.apply(new TransactionDto(Operation.BALANCE,
                new Fruit("banana"), 20));
        reductionStrategy.apply(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 10));
        Integer actul = Storage.fruits.size();
        assertEquals(Integer.valueOf(10), actul);
    }

    @Test(expected = RuntimeException.class)
    public void subtractionBadData_Ok() {
        transactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), -10));
        fruitService.applyAllOperators(transactionDtos);
    }

    @Test(expected = RuntimeException.class)
    public void subtractionMoreThanWeHave_Ok() {
        transactionDtos.add(new TransactionDto(Operation.PURCHASE,
                new Fruit("banana"), 50));
        fruitService.applyAllOperators(transactionDtos);
    }
}
