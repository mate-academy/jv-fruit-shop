package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.Operation;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FruitServiceImplTest {
    private static FruitService fruitService;
    private static FruitsDao fruitsDao;
    private static  Map<String, OperationHandler> operationHandlerMap;
    private static OperationStrategy operationStrategy;
    private static List<String> testDataOk;
    private static List<String> testDataNotOk;

    @BeforeAll
    public static void setUp() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE.getText(), new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE.getText(), new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY.getText(), new SupplyOperationHandler());
        operationHandlerMap.put(Operation.RETURN.getText(), new ReturnOperationHandler());

        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        fruitsDao = new FruitsDaoImpl();
        fruitService = new FruitServiceImpl(fruitsDao,operationStrategy);

        testDataOk = List.of("b,banana,20", "b,apple,100", "s,banana,100", "s,apple,100",
                "p,banana,100", "p,apple,20", "r,banana,5", "r,apple,50");
        testDataNotOk = List.of("a,banana,20", "b,apple,100", "s,banana,100", "s,apple,100",
                "p,banana,100", "p,apple,20", "r,banana,5", "r,apple,50");
    }

    @Test
    public void calculateFruitsBalance_Ok() {
        List<Fruit> expected = List.of(new Fruit("banana", 25),
                new Fruit("apple", 230));
        fruitService.calculateFruitsBalance(testDataOk);
        List<Fruit> actual = fruitsDao.getData();
        assertEquals(expected, actual);
    }

    @Test
    public void calculateFruitsBalance_ThrowsException() {
        assertThrows(RuntimeException.class, () -> {
            fruitService.calculateFruitsBalance(testDataNotOk);
        });
    }
}
