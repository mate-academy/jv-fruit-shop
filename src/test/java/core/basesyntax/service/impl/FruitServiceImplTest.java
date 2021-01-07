package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
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
import org.junit.Test;

public class FruitServiceImplTest {

    @Test
    public void fruitServiceTest() {
        Storage.fruitsMap.clear();
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);

        List<TransactionDto> transactionDtoList = List.of(
                new TransactionDto(Operation.BALANCE, new Fruit("apple"), 20),
                new TransactionDto(Operation.BALANCE, new Fruit("apple"), 100),
                new TransactionDto(Operation.BALANCE, new Fruit("banana"), 100),
                new TransactionDto(Operation.PURCHASE, new Fruit("apple"), 50),
                new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 5),
                new TransactionDto(Operation.RETURN, new Fruit("apple"), 5),
                new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 5));

        fruitService.applyOperationsOnFruitsDto(transactionDtoList);
        Map<Fruit, Integer> expected = new HashMap<>();
        expected.put(new Fruit("banana"), 100);
        expected.put(new Fruit("apple"), 75);
        Assert.assertEquals(expected, fruitService.getFruitReport());
    }
}
