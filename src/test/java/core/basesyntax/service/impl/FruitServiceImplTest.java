package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceStrategy;
import core.basesyntax.strategy.impl.PurchaseStrategy;
import core.basesyntax.strategy.impl.ReturnStrategy;
import core.basesyntax.strategy.impl.SupplyStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitServiceImplTest {
    private static FruitServiceImpl fruitService = new FruitServiceImpl(getOperation());
    private static List<TransactionDto> transactionDtoList = new ArrayList<>();

    @Test
    public void applyBalanceOperation_ok() {
        transactionDtoList
                .add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 10));
        Map<Fruit, Integer> expected = new HashMap<>();
        expected.put(new Fruit("banana"), 10);
        fruitService.applyOperationOnFruitDto(transactionDtoList);
        Assert.assertEquals(expected, Storage.getFruitsStorage());
    }

    @Test
    public void applyPurchaseOperation_ok() {
        transactionDtoList
                .add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 10));
        transactionDtoList
                .add(new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 5));
        Map<Fruit, Integer> expected = new HashMap<>();
        expected.put(new Fruit("banana"), 5);
        fruitService.applyOperationOnFruitDto(transactionDtoList);
        Assert.assertEquals(expected, Storage.getFruitsStorage());
    }

    @Test
    public void applyReturnOperation_ok() {
        transactionDtoList
                .add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 10));
        transactionDtoList.add(new TransactionDto(Operation.RETURN, new Fruit("banana"), 5));
        Map<Fruit, Integer> expected = new HashMap<>();
        expected.put(new Fruit("banana"), 15);
        fruitService.applyOperationOnFruitDto(transactionDtoList);
        Assert.assertEquals(expected, Storage.getFruitsStorage());
    }

    @Test
    public void applySupplyOperation_ok() {
        transactionDtoList
                .add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), 10));
        transactionDtoList.add(new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 7));
        Map<Fruit, Integer> expected = new HashMap<>();
        expected.put(new Fruit("banana"), 17);
        fruitService.applyOperationOnFruitDto(transactionDtoList);
        Assert.assertEquals(expected, Storage.getFruitsStorage());
    }

    @Test(expected = RuntimeException.class)
    public void applyBalanceOperation_notOk() {
        transactionDtoList
                .add(new TransactionDto(Operation.BALANCE, new Fruit("banana"), null));
        fruitService.applyOperationOnFruitDto(transactionDtoList);

    }

    @Test(expected = RuntimeException.class)
    public void applyPurchaseOperation_notOk() {
        transactionDtoList
                .add(new TransactionDto(Operation.PURCHASE, new Fruit("banana"), 5));
        fruitService.applyOperationOnFruitDto(transactionDtoList);
    }

    @Test(expected = RuntimeException.class)
    public void applyReturnOperation_notOk() {
        transactionDtoList
                .add(new TransactionDto(Operation.RETURN, new Fruit("banana"), 7));
        fruitService.applyOperationOnFruitDto(transactionDtoList);
    }

    @Test(expected = RuntimeException.class)
    public void applySupplyOperation_notOk() {
        transactionDtoList
                .add(new TransactionDto(Operation.SUPPLY, new Fruit("banana"), 5));
        fruitService.applyOperationOnFruitDto(transactionDtoList);
    }

    private static Map<Operation, OperationStrategy> getOperation() {
        Map<Operation, OperationStrategy> operations = new HashMap<>();
        operations.put(Operation.BALANCE, new BalanceStrategy());
        operations.put(Operation.PURCHASE, new PurchaseStrategy());
        operations.put(Operation.RETURN, new ReturnStrategy());
        operations.put(Operation.SUPPLY, new SupplyStrategy());
        return operations;
    }

    @Test
    public void getFruitReport_ok() {
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("banana", 5);
        Storage.getFruitsStorage().put(new Fruit("banana"), 5);
        Map<String, Integer> actualMap = fruitService.getFruitReport();
        Assert.assertEquals(expectedMap, actualMap);

    }

    @Before
    public void setUp() {
        Storage.getFruitsStorage().clear();
        transactionDtoList.clear();
    }
}
