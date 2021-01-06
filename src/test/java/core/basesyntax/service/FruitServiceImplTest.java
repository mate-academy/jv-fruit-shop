package core.basesyntax.service;

import core.basesyntax.database.Storage;
import core.basesyntax.model.BalanceOperation;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationStrategy;
import core.basesyntax.model.OperationStrategyImpl;
import core.basesyntax.model.Operations;
import core.basesyntax.model.PurchaseOperation;
import core.basesyntax.model.ReturnOperation;
import core.basesyntax.model.SupplyOperation;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
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
        fruitService.saveToStorage(new FileReaderImpl().read("src/test/resources/test2.csv"));
        String actual = fruitService.getReportFromStorage();
        String expected = "fruit,quantity" + System.lineSeparator() + "apple,90"
                + System.lineSeparator() + "banana,152";
        Assert.assertEquals(expected, actual);
    }
}
