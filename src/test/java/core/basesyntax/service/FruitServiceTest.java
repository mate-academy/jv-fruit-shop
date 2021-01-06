package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.strategies.BalanceStrategy;
import core.basesyntax.strategy.strategies.PurchaseStrategy;
import core.basesyntax.strategy.strategies.ReturnStrategy;
import core.basesyntax.strategy.strategies.SupplyStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceTest {
    private static final String FILE_FROM = "src/test/resources/shop_activity_test.csv";
    private static final String FILE_INVALID_OPERATION
            = "src/test/resources/shop_activity_test_invalid_operation.csv";
    private static final Fruit BANANA = new Fruit("banana");
    private static final Fruit APPLE = new Fruit("apple");
    private static final TransactionDto BALANCE_BANANA_TRANSACTION
            = new TransactionDto(Operation.BALANCE, BANANA, 100);
    private static final TransactionDto BALANCE_APPLE_TRANSACTION
            = new TransactionDto(Operation.BALANCE, APPLE, 100);
    private static final TransactionDto PURCHASE_BANANA_TRANSACTION
            = new TransactionDto(Operation.PURCHASE, BANANA, 20);
    private static final TransactionDto PURCHASE_APPLE_TRANSACTION
            = new TransactionDto(Operation.PURCHASE, APPLE, 20);
    private static final TransactionDto RETURN_BANANA_TRANSACTION
            = new TransactionDto(Operation.RETURN, BANANA, 30);
    private static final TransactionDto RETURN_APPLE_TRANSACTION
            = new TransactionDto(Operation.RETURN, APPLE, 30);
    private static final TransactionDto SUPPLY_BANANA_TRANSACTION
            = new TransactionDto(Operation.SUPPLY, BANANA, 50);
    private static final TransactionDto SUPPLY_APPLE_TRANSACTION
            = new TransactionDto(Operation.SUPPLY, APPLE, 50);
    private static final TransactionDto BALANCE_APPLE_INVALID_TRANSACTION
            = new TransactionDto(Operation.BALANCE, APPLE, -100);
    private static final TransactionDto PURCHASE_BANANA_INVALID_TRANSACTION
            = new TransactionDto(Operation.PURCHASE, BANANA, -20);
    private static Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
    private static FruitService service;
    private List<TransactionDto> testData = new ArrayList<>();

    @BeforeClass
    public static void setUp() {
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        service = new FruitServiceImpl(operationStrategyMap);
    }

    @Test
    public void validFileData() {
        testData = new ArrayList<>();
        testData.add(BALANCE_BANANA_TRANSACTION);
        testData.add(BALANCE_APPLE_TRANSACTION);
        testData.add(PURCHASE_BANANA_TRANSACTION);
        testData.add(PURCHASE_APPLE_TRANSACTION);
        testData.add(SUPPLY_BANANA_TRANSACTION);
        testData.add(SUPPLY_APPLE_TRANSACTION);
        testData.add(RETURN_BANANA_TRANSACTION);
        testData.add(RETURN_APPLE_TRANSACTION);
        service.processActivities(testData);
        Map<Fruit, Integer> report = service.getReport();
        Assert.assertEquals(Integer.valueOf(160), report.get(BANANA));
        Assert.assertEquals(Integer.valueOf(160), report.get(APPLE));
    }

    @Test(expected = RuntimeException.class)
    public void invalidFileData_OperationType() {
        testData = new ArrayList<>();
        testData.add(BALANCE_BANANA_TRANSACTION);
        testData.add(BALANCE_APPLE_INVALID_TRANSACTION);
        testData.add(PURCHASE_BANANA_INVALID_TRANSACTION);
        testData.add(PURCHASE_APPLE_TRANSACTION);
        testData.add(SUPPLY_BANANA_TRANSACTION);
        testData.add(SUPPLY_APPLE_TRANSACTION);
        testData.add(RETURN_BANANA_TRANSACTION);
        testData.add(RETURN_APPLE_TRANSACTION);
        service.processActivities(testData);
    }

    @After
    public void afterClass() {
        testData.clear();
    }
}
