package core.basesyntax.strategy;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.impl.FruitServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdditionalStrategyTest {
    public static FruitServiceImpl fruitService;
    public static List<TransactionDto> transactionDtos;
    public static Map<Operation, OperationStrategy> operationStrategyMap;

    @BeforeClass
    public static void beforeClass() {
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
    public void additional_Ok() {
        fruitService.applyAllOperators(transactionDtos);
        Integer actul = Storage.fruits.size();
        assertEquals(Integer.valueOf(10), actul);
    }
}
