package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.stratege.BalanceStrategy;
import core.basesyntax.stratege.OperationStrategy;
import core.basesyntax.stratege.PurchaseStrategy;
import core.basesyntax.stratege.ReturnStrategy;
import core.basesyntax.stratege.SupplyStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static FruitServiceImpl fruitService;
    private static Map<Operation, OperationStrategy> operationMap;
    private static List<TransactionDto> transactionDtoList;
    private static Map<Fruit, Integer> fruits;

    @BeforeClass
    public static void beforeClass() {
        operationMap = new HashMap<>();
        transactionDtoList = new ArrayList<>();
        fruits = new HashMap<>();
        fruitService = new FruitServiceImpl(operationMap);
    }

    @After
    public void tearDown() {
        Storage.fruitsAndAmountsMap.clear();
        transactionDtoList.clear();
    }

    @Test(expected = RuntimeException.class)
    public void selectOperationAndWriteToStorageNullValue_NotOk() {
        fruitService.selectOperationAndWriteToStorage(null);
    }

    @Test
    public void selectOperationAndWriteToStorageBalanceOperation_Ok() {
        operationMap.put(Operation.BALANCE, new BalanceStrategy());
        transactionDtoList.add(new TransactionDto(Operation.BALANCE, new Fruit("Apple"), 100));
        fruits.put(new Fruit("Apple"), 100);
        fruitService.selectOperationAndWriteToStorage(transactionDtoList);
        Set<Map.Entry<Fruit, Integer>> expected = fruits.entrySet();
        Set<Map.Entry<Fruit, Integer>> actual = Storage.fruitsAndAmountsMap.entrySet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void selectOperationAndWriteToStorageReturnOperation_Ok() {
        Storage.fruitsAndAmountsMap.put(new Fruit("Apple"), 100);
        operationMap.put(Operation.RETURN, new ReturnStrategy());
        transactionDtoList.add(new TransactionDto(Operation.RETURN, new Fruit("Apple"), 20));
        fruits.put(new Fruit("Apple"), 120);
        fruitService.selectOperationAndWriteToStorage(transactionDtoList);
        Set<Map.Entry<Fruit, Integer>> expected = fruits.entrySet();
        Set<Map.Entry<Fruit, Integer>> actual = Storage.fruitsAndAmountsMap.entrySet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void selectOperationAndWriteToStorageSupplyOperation_Ok() {
        Storage.fruitsAndAmountsMap.put(new Fruit("Apple"), 100);
        operationMap.put(Operation.SUPPLY, new SupplyStrategy());
        transactionDtoList.add(new TransactionDto(Operation.SUPPLY, new Fruit("Apple"), 20));
        fruits.put(new Fruit("Apple"), 120);
        fruitService.selectOperationAndWriteToStorage(transactionDtoList);
        Set<Map.Entry<Fruit, Integer>> expected = fruits.entrySet();
        Set<Map.Entry<Fruit, Integer>> actual = Storage.fruitsAndAmountsMap.entrySet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void selectOperationAndWriteToStorageAllOperation_Ok4() {
        Storage.fruitsAndAmountsMap.put(new Fruit("Apple"), 100);
        operationMap.put(Operation.PURCHASE, new PurchaseStrategy());
        transactionDtoList.add(new TransactionDto(Operation.PURCHASE, new Fruit("Apple"), 20));
        fruits.put(new Fruit("Apple"), 80);
        fruitService.selectOperationAndWriteToStorage(transactionDtoList);
        Set<Map.Entry<Fruit, Integer>> expected = fruits.entrySet();
        Set<Map.Entry<Fruit, Integer>> actual = Storage.fruitsAndAmountsMap.entrySet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void prepareDataForReport() {
        Storage.fruitsAndAmountsMap.put(new Fruit("apple"), 100);
        Storage.fruitsAndAmountsMap.put(new Fruit("banana"), 20);
        String expected = "fruit,quantity" + System.lineSeparator() + "banana,20"
                + System.lineSeparator() + "apple,100" + System.lineSeparator();
        String actual = fruitService.prepareDataForReport();
        Assert.assertEquals(expected, actual);
    }
}
