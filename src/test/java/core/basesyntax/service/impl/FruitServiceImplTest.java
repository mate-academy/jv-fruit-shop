package core.basesyntax.service.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.AdditionStrategyImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static Map<Operation, OperationStrategy> operationStrategyMap;
    private static FruitService fruitService;
    private static List<TransactionDto> transactionDtoListCorrect;
    private static final TransactionDto testDto1 = new TransactionDto(Operation.BALANCE,
            new Fruit("banana"), 20);
    private static final TransactionDto testDto2 = new TransactionDto(Operation.SUPPLY,
            new Fruit("apple"), 100);
    private static final TransactionDto testDto3 = new TransactionDto(Operation.PURCHASE,
            new Fruit("banana"), 100);
    private static final TransactionDto testDto4 = new TransactionDto(Operation.RETURN,
            new Fruit("apple"), 100);
    private static final TransactionDto testDto5 = new TransactionDto(Operation.SUPPLY,
            new Fruit("apple"), -100);
    private static final TransactionDto testDto6 = new TransactionDto(Operation.PURCHASE,
            new Fruit("apple"), 50);

    @BeforeClass
    public static void beforeAll() {
        operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategyImpl());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategyImpl());
        fruitService = new FruitServiceImpl(operationStrategyMap);
        transactionDtoListCorrect = List.of(testDto1, testDto2, testDto4, testDto6);
    }

    @Before
    public void setUp() throws Exception {
        Storage.getFruits().clear();
    }

    @Test
    public void transactionToDB_Ok() {
        fruitService.applyTransactionsToDB(transactionDtoListCorrect);
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("banana", 20);
        expectedMap.put("apple", 150);
        assertEquals(expectedMap, Storage.getFruits());
    }

    @Test
    public void getReport_Ok() {
        fruitService.applyTransactionsToDB(transactionDtoListCorrect);
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,20" + System.lineSeparator() + "apple,150";
        String actual = fruitService.getReport();
        assertEquals(expected, actual);
    }
}
