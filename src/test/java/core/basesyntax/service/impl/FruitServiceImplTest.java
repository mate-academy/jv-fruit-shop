package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitServiceImplTest {
    private FruitService fruitService;

    @Before
    public void setUp() {
        fruitService = new FruitServiceImpl(operationStrategyMap());
    }

    @Test
    public void correctStorage_Ok() {
        List<TransactionDto> transactionDtoList = List.of(
                new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20),
                new TransactionDto(Operation.BALANCE, new Fruit("apple"), 100),
                new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 13),
                new TransactionDto(Operation.RETURN, new Fruit("apple"), 10),
                new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 20));

        fruitService.applyOperationsOnFruitsDto(transactionDtoList);

        Map<Fruit, Integer> actual = fruitService.getFruitsReport();
        Map<Fruit, Integer> expected = new HashMap<>();
        expected.put(new Fruit("banana"), 27);
        expected.put(new Fruit("apple"), 110);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void incorrectPurchaseStrategy_notOk() {
        List<TransactionDto> transactionDtoList = List.of(
                new TransactionDto(Operation.BALANCE, new Fruit("banana"), 20),
                new TransactionDto(Operation.BALANCE, new Fruit("apple"), 100),
                new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 50));

        fruitService.applyOperationsOnFruitsDto(transactionDtoList);
    }

    private Map<Operation, OperationStrategy> operationStrategyMap() {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        return operationStrategyMap;
    }
}
