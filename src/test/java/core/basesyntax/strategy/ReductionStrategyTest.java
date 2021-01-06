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

public class ReductionStrategyTest {
    public static FruitServiceImpl fruitService;
    public static List<TransactionDto> transactionDtoList;
    public static Map<Operation, OperationStrategy> operationStrategyMap;
    public static ReductionStrategy reductionStrategy;

    @BeforeClass
    public static void beforeClass() throws Exception {
        reductionStrategy = new ReductionStrategy();
        transactionDtoList = new ArrayList<>();
        operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());
        fruitService = new FruitServiceImpl(operationStrategyMap);
        transactionDtoList.add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 40));
        transactionDtoList.add(new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 40));
        transactionDtoList.add(new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 60));
    }

    @Test
    public void reduction_Ok() {
        Storage.fruits.removeAll(Storage.fruits);
        fruitService.applyOperationOnFruitDto(transactionDtoList);
        Integer actual = Storage.fruits.size();
        assertEquals(Integer.valueOf(20), actual);
    }

    @Test
    public void own_reduction_Ok() {
        Storage.fruits.removeAll(Storage.fruits);
        fruitService.applyOperationOnFruitDto(transactionDtoList);
        reductionStrategy.apply(new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 5));
        Integer actual = Storage.fruits.size();
        assertEquals(Integer.valueOf(15), actual);
    }

    @Test(expected = RuntimeException.class)
    public void balance_less_purchase_Exception_Ok() {
        Storage.fruits.removeAll(Storage.fruits);
        reductionStrategy.apply(new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 5));
    }
}
