package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.AdditionalStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    public static FruitServiceImpl fruitService;
    public static List<TransactionDto> transactionDtos;
    public static Map<Operation, OperationStrategy> operationStrategyMap;

    @BeforeClass
    public static void beforeClass() throws Exception {
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
    public void applyAllOperators_Ok() {
        fruitService.applyAllOperators(transactionDtos);
        Integer actul = Storage.fruits.size();
        assertEquals(Integer.valueOf(10), actul);
    }

    @Test
    public void getReport_Ok() {
        Map<String, Long> stringLongMap = fruitService.getReport();
        for (Map.Entry<String, Long> entry : stringLongMap.entrySet()) {
            assertEquals("banana", entry.getKey());
            assertEquals(Long.valueOf(10), entry.getValue());
        }
    }
}
