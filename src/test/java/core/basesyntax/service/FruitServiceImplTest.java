package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static FruitService fruitService;
    private static OperationStrategy operationStrategy;
    private static Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
    private static List<Transaction> transactions;
    private static Map<Fruit, Integer> expectedStorage;

    @BeforeClass
    public static void beforeClass() throws Exception {
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        fruitService = new FruitServiceImpl(operationStrategy);
        transactions = Arrays.asList(
                new Transaction(Operation.BALANCE, new Fruit("apple"), 100),
                new Transaction(Operation.PURCHASE, new Fruit("apple"), 50),
                new Transaction(Operation.BALANCE, new Fruit("banana"), 300),
                new Transaction(Operation.SUPPLY, new Fruit("banana"), 500)
        );
        expectedStorage = new HashMap<>();
        expectedStorage.put(new Fruit("apple"), 50);
        expectedStorage.put(new Fruit("banana"), 800);
    }

    @Test
    public void whenCreateReport_expectedStorage() {
        fruitService.createReport(transactions);
        Assert.assertEquals(expectedStorage, Storage.fruitStorage);
    }
}
