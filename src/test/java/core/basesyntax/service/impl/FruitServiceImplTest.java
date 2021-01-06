package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.AdditionStrategy;
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
    public static List<TransactionDto> transactionDtoList;
    public static Map<Operation, OperationStrategy> operationStrategyMap;

    @BeforeClass
    public static void beforeClass() throws Exception {
        operationStrategyMap = new HashMap<>();
        transactionDtoList = new ArrayList<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());
        fruitService = new FruitServiceImpl(operationStrategyMap);
        transactionDtoList.add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 30));
        transactionDtoList.add(new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 30));
        transactionDtoList.add(new TransactionDto(Operation.RETURN, new Fruit("banana"), 10));
        fruitService = new FruitServiceImpl(operationStrategyMap);
        Storage.fruits.removeAll(Storage.fruits);
    }

    @Test
    public void applyOperationOnFruitDto_method_Ok() {
        fruitService.applyOperationOnFruitDto(transactionDtoList);
        Integer actual = Storage.fruits.size();
        assertEquals(Integer.valueOf(70), actual);
    }

    @Test
    public void getFruitReport_method_Ok() {
        Map<String, Long> expected = fruitService.getFruitReport();
        for (Map.Entry<String, Long> entry : expected.entrySet()) {
            assertEquals("banana", entry.getKey());
            assertEquals(Long.valueOf(70), entry.getValue());
        }
    }
}
