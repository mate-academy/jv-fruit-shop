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
import java.util.ArrayList;
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
    private static List<TransactionDto> transactionDtoListIncorrectAmount;
    private static List<TransactionDto> transactionDtoListIncorrectResult;
    private static final TransactionDto testDto1 = new TransactionDto(Operation.fromString("b"),
            new Fruit("banana"), 20);
    private static final TransactionDto testDto2 = new TransactionDto(Operation.fromString("s"),
            new Fruit("apple"), 100);
    private static final TransactionDto testDto3 = new TransactionDto(Operation.fromString("p"),
            new Fruit("banana"), 100);
    private static final TransactionDto testDto4 = new TransactionDto(Operation.fromString("r"),
            new Fruit("apple"), 100);
    private static final TransactionDto testDto5 = new TransactionDto(Operation.fromString("s"),
            new Fruit("apple"), -100);
    private static final TransactionDto testDto6 = new TransactionDto(Operation.fromString("p"),
            new Fruit("apple"), 50);

    @BeforeClass
    public static void beforeAll() {
        operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategyImpl());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategyImpl());
        fruitService = new FruitServiceImpl(operationStrategyMap);
        transactionDtoListCorrect = new ArrayList<>();
        transactionDtoListIncorrectAmount = new ArrayList<>();
        transactionDtoListIncorrectResult = new ArrayList<>();
        transactionDtoListCorrect.add(testDto1);
        transactionDtoListCorrect.add(testDto2);
        transactionDtoListCorrect.add(testDto4);
        transactionDtoListCorrect.add(testDto6);
        transactionDtoListIncorrectAmount.add(testDto5);
        transactionDtoListIncorrectResult.add(testDto1);
        transactionDtoListIncorrectAmount.add(testDto3);
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
        transactionToDB_Ok();
        String expected = "fruit,quantity\nbanana,20\napple,150";
        String actual = fruitService.getReport();
        assertEquals(expected, actual);
    }
}
