package core.basesyntax.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationAddition;
import core.basesyntax.strategy.OperationReduction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static final Map<Operation, OperationStrategy> testMapOperation = new HashMap<>();
    private static final Map<String, Long> testMapReport = new HashMap<>();
    private static FruitService testFruitService;

    @BeforeClass
    public static void beforeClass() {
        testMapOperation.put(Operation.BALANCE, new OperationAddition());
        testMapOperation.put(Operation.SUPPLY, new OperationAddition());
        testMapOperation.put(Operation.PURCHASE, new OperationReduction());
        testMapOperation.put(Operation.RETURN, new OperationAddition());
        testFruitService = new FruitServiceImpl(testMapOperation);
        testMapReport.put("banana", 1L);
        testMapReport.put("apple", 2L);

    }

    @Test
    public void testStorageForSavingFruits() {
        List<Fruit> testStorage = new ArrayList<>();
        testStorage.add(0, new Fruit("banana"));
        testStorage.add(1, new Fruit("apple"));
        assertEquals(2, testStorage.size());
    }

    @Test
    public void testApplyOperationsAddition() {
        TransactionDto transactionDto1 = new TransactionDto();
        transactionDto1.setQuantity(2);
        transactionDto1.setOperation(Operation.BALANCE);
        transactionDto1.setFruit(new Fruit("banana"));
        List<TransactionDto> transactionDtos = new ArrayList<>();
        transactionDtos.add(transactionDto1);
        testFruitService.applyOperations(transactionDtos);
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("banana"));
        expected.add(new Fruit("banana"));
        assertEquals(Storage.fruits, expected);
    }

    @Test
    public void testApplyOperationsReduction() {
        TransactionDto transactionDtoSupply = new TransactionDto();
        transactionDtoSupply.setQuantity(3);
        transactionDtoSupply.setOperation(Operation.SUPPLY);
        transactionDtoSupply.setFruit(new Fruit("apple"));
        List<TransactionDto> transactionDtos = new ArrayList<>();
        transactionDtos.add(transactionDtoSupply);
        TransactionDto transactionDtoPurchase = new TransactionDto();
        transactionDtoPurchase.setQuantity(2);
        transactionDtoPurchase.setOperation(Operation.PURCHASE);
        transactionDtoPurchase.setFruit(new Fruit("apple"));
        transactionDtos.add(transactionDtoPurchase);
        testFruitService.applyOperations(transactionDtos);
        List<Fruit> expected = new ArrayList<>();
        expected.add(new Fruit("apple"));
        assertEquals(Storage.fruits, expected);
    }

    @Test
    public void testForGettingReport() {
        Storage.fruits.add(new Fruit("banana"));
        Storage.fruits.add(new Fruit("apple"));
        Storage.fruits.add(new Fruit("apple"));
        assertEquals(testMapReport, testFruitService.getReport());
    }

    @After
    public void after() {
        Storage.fruits.clear();
    }
}
