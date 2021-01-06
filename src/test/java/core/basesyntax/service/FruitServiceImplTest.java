package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.fruitoperation.strategy.OperationStrategyImpl;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
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
        operationMap.put(Operations.B, new OperationBalance());
        operationMap.put(Operations.P, new OperationPurchase());
        operationMap.put(Operations.R, new OperationReturn());
        operationMap.put(Operations.S, new OperationSupply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        fruitService = new FruitServiceImpl(operationStrategy);
    }

    @Before
    public void setUp() {
        Storage.setFruits(new TreeMap<>());
    }

    @Test
    public void test1ReportFormatting_Ok() {
        Storage.getFruits().put(new Fruit("apple"), 90);
        Storage.getFruits().put(new Fruit("banana"), 152);
        List<String> actual = fruitService.getFromStorage();
        List<String> expected = List.of("fruit,quantity",System.lineSeparator() + "apple,90",
                System.lineSeparator() + "banana,152");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2ReportFormatting_Ok() {
        List<String> input = new ArrayList<>();
        input.add("operation,fruit,amount");
        input.add("b,banana,20");
        input.add("b,apple,100");
        input.add("s,banana,100");
        input.add("p,banana,13");
        input.add("r,apple,10");
        input.add("p,apple,20");
        input.add("p,banana,5");
        input.add("s,banana,50");
        fruitService.saveToStorage(input);
        List<String> actual = Storage.getFruits().entrySet()
                .stream()
                .map(e -> e.getKey().getName() + "," + e.getValue())
                .collect(Collectors.toList());
        List<String> expected = List.of("apple,90", "banana,152");
        Assert.assertEquals(expected, actual);
    }
}
