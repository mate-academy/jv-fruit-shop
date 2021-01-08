package core.basesyntax.service;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.Operations;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static FruitService fruitService;

    @BeforeClass
    public static void beforeClass() {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.BALANCE, new BalanceOperation());
        operationMap.put(Operations.PURCHASE, new PurchaseOperation());
        operationMap.put(Operations.RETURN, new ReturnOperation());
        operationMap.put(Operations.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        fruitService = new FruitServiceImpl(operationStrategy);
    }

    @Before
    public void setUp() {
        Storage.setFruitsMap(new TreeMap<>());
    }

    @Test
    public void test1Report_Ok() {
        Storage.getFruitsMap().put(new Fruit("apple"), 90);
        Storage.getFruitsMap().put(new Fruit("banana"), 152);
        String actual = fruitService.getReportFromStorage();
        String expected = "fruit,quantity" + System.lineSeparator() + "apple,90"
                + System.lineSeparator() + "banana,152";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2Report_Ok() {
        fruitService.saveToStorage(List.of("b,banana,20", "b,apple,100", "s,banana,100",
                "p,banana,13", "r,apple,10", "p,apple,20", "p,banana,5", "s,banana,50"));
        List<String> actual = Storage.getFruitsMap().entrySet()
                .stream()
                .map(e -> e.getKey().getName() + "," + e.getValue())
                .collect(Collectors.toList());
        List<String> expected = List.of("apple,90", "banana,152");
        Assert.assertEquals(expected, actual);
    }
}
