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
    private static final TransactionDto TEST_DTO_1 = new TransactionDto(Operation.BALANCE,
            new Fruit("banana"), 20);
    private static final TransactionDto TEST_DTO_2 = new TransactionDto(Operation.SUPPLY,
            new Fruit("apple"), 100);
    private static final TransactionDto TEST_DTO_4 = new TransactionDto(Operation.RETURN,
            new Fruit("apple"), 100);
    private static final TransactionDto TEST_DTO_6 = new TransactionDto(Operation.PURCHASE,
            new Fruit("apple"), 50);

    @BeforeClass
    public static void beforeAll() {
        operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategyImpl());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategyImpl());
        fruitService = new FruitServiceImpl(operationStrategyMap);
        transactionDtoListCorrect = List.of(TEST_DTO_1, TEST_DTO_2, TEST_DTO_4, TEST_DTO_6);
    }

    @Before
    public void setUp() {
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
        Storage.getFruits().put("banana", 20);
        Storage.getFruits().put("apple", 150);
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,20" + System.lineSeparator() + "apple,150";
        String actual = fruitService.getReport();
        assertEquals(expected, actual);
    }
}
