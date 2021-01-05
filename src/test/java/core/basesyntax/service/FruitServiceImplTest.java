package core.basesyntax.service;

import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.fruitoperation.strategy.OperationStrategyImpl;
import core.basesyntax.service.file.DataReader;
import core.basesyntax.service.file.impl.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitServiceImplTest {
    private static FruitService fruitService;

    @Before
    public void setUp() throws Exception {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new OperationBalance());
        operationMap.put(Operations.P, new OperationPurchase());
        operationMap.put(Operations.R, new OperationReturn());
        operationMap.put(Operations.S, new OperationSupply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        fruitService = new FruitServiceImpl(operationStrategy);
    }

    @Test
    public void test1ReportFormatting_Ok() {
        DataReader dataReader = new FileReader();
        fruitService.saveToStorage(dataReader.readData("src/main/resources/test1_correct.csv"));
        String actual = fruitService.getFromStorage();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,90" + System.lineSeparator() + "banana,152";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2ReportFormatting_Ok() {
        DataReader dataReader = new FileReader();
        fruitService.saveToStorage(dataReader.readData("src/main/resources/test2_correct.csv"));
        String actual = fruitService.getFromStorage();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,90" + System.lineSeparator() + "banana,152";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3ReportFormatting_incorrectOperation() {
        try {
            DataReader dataReader = new FileReader();
            fruitService.saveToStorage(
                    dataReader.readData("src/main/resources/test3_incorrect.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals("Incorrect data", e.getMessage());
        }
    }

    @Test
    public void test4ReportFormatting_operationDontPass() {
        try {
            DataReader dataReader = new FileReader();
            fruitService.saveToStorage(
                    dataReader.readData("src/main/resources/test4_incorrect.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals("Incorrect data", e.getMessage());
        }
    }
}
