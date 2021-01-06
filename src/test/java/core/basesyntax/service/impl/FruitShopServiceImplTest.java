package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.AdditionStrategyImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategyImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitShopServiceImplTest {

    static Map<Fruit, Integer> fruitStorage;
    static FruitShopService fruitShop;
    static List<TransactionDto> transactionDtoList;

    @Before
    public void setUp() throws Exception {
        fruitStorage = new HashMap<Fruit, Integer>();
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategyImpl());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategyImpl());
        fruitShop = new FruitShopServiceImpl(operationStrategyMap);
        transactionDtoList = new ArrayList<>();
        new TransactionDto(Operation.BALANCE, new Fruit("cherry"), 15);
        new TransactionDto(Operation.SUPPLY, new Fruit("melon"), 30);
        transactionDtoList.add(new TransactionDto(Operation.BALANCE, new Fruit("cherry"), 15));
        transactionDtoList.add(new TransactionDto(Operation.SUPPLY, new Fruit("cherry"), 30));
    }

    @Test
    public void validData_ok() {
        Fruit pineapple = new Fruit("pinapple");
        Fruit cherry = new Fruit("cherry");
        fruitStorage.put(pineapple, 1);
        fruitStorage.put(cherry, 10);
        Assert.assertEquals(java.util.Optional.ofNullable(fruitStorage.get(pineapple)),
                Optional.of(1));
        Assert.assertEquals(java.util.Optional.ofNullable(fruitStorage.get(cherry)),
                Optional.of(10));
        Assert.assertEquals(java.util.Optional.ofNullable(fruitStorage.size()),
                Optional.of(2));
    }

    @Test
    public void invalidData_NotOk() {
        Fruit grapes = new Fruit("grapes");
        Fruit orange = new Fruit("orange");
        fruitStorage.put(grapes, 20);
        fruitStorage.put(orange, 10);
        Assert.assertNotEquals(java.util.Optional.ofNullable(fruitStorage.get(grapes)),
                Optional.of(10));
        Assert.assertNotEquals(java.util.Optional.ofNullable(fruitStorage.get(orange)),
                Optional.of(20));
        Assert.assertNotEquals(java.util.Optional.ofNullable(fruitStorage.size()),
                Optional.of(3));
    }

    @Test
    public void wrongFormatWriteData_ok() {
        Fruit grapes = new Fruit("grapes");
        Fruit orange = new Fruit("orange");
        fruitStorage.put(grapes, 20);
        fruitStorage.put(orange, 10);
        Assert.assertNotEquals(java.util.Optional.ofNullable(fruitStorage.get(grapes)),
                Optional.of(100));
        Assert.assertNotEquals(java.util.Optional.ofNullable(fruitStorage.get(orange)),
                Optional.of(200));
        Assert.assertNotEquals(java.util.Optional.ofNullable(fruitStorage.size()),
                Optional.of(30));
    }

    @Test
    public void performFruitService_ok() {
        fruitShop.applyOperationOnFruitsDto(transactionDtoList);
        Integer actual = Storage.fruitStorage.get(new Fruit("cherry"));
        Integer expected = Integer.valueOf(45);
        Assert.assertEquals(actual, expected);
    }
}
