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
import core.basesyntax.service.file.DataReader;
import core.basesyntax.service.file.DataValidator;
import core.basesyntax.service.file.impl.DataValidatorImpl;
import core.basesyntax.service.file.impl.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FruitServiceImplTest {
    private static FruitService fruitService;
    private static DataValidator validator;
    private static DataReader reader;

    @BeforeClass
    public static void beforeClass() throws Exception {
        validator = new DataValidatorImpl();
        reader = new FileReader(validator);
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
        fruitService.saveToStorage(reader.readData("src/test/resources/test1_correct.csv"));
        List<String> actual = fruitService.getFromStorage();
        List<String> expected = List.of("fruit,quantity",System.lineSeparator() + "apple,90",
                System.lineSeparator() + "banana,152");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2ReportFormatting_Ok() {
        fruitService.saveToStorage(reader.readData("src/test/resources/test2_correct.csv"));
        List<String> actual = fruitService.getFromStorage();
        List<String> expected = List.of("fruit,quantity",System.lineSeparator() + "apple,90",
                System.lineSeparator() + "banana,152");
        Assert.assertEquals(expected, actual);
    }
}
