package core.basesyntax.workwithfiles.impl;

import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.fruitoperation.strategy.OperationStrategyImpl;
import core.basesyntax.report.ReportFormatter;
import core.basesyntax.report.ReportFormatterImpl;
import core.basesyntax.workwithfiles.DataReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTest extends TestCase {
    private static ReportFormatter reportFormatter;

    @Before
    public void setUp() throws Exception {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new OperationBalance());
        operationMap.put(Operations.P, new OperationPurchase());
        operationMap.put(Operations.R, new OperationReturn());
        operationMap.put(Operations.S, new OperationSupply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        reportFormatter = new ReportFormatterImpl(operationStrategy);
    }

    @Test
    public void testName() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,20");
        expected.add("b,apple,100");
        expected.add("s,banana,100");
        DataReader dataReader = new FileReader("src/main/resources/data_for_FR.csv");
        assertEquals(expected, dataReader.readData());
    }

    @Test
    public void testIncorrectStrings() {
        try {
            reportFormatter.createReport(
                    new FileReader("src/main/resources/test_FR_hardcode1.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals("Incorrect data", e.getMessage());
        }
    }

    @Test
    public void testIncorrectName() {
        try {
            reportFormatter.createReport(
                    new FileReader("src/main/resources/test_FR_hardcode2.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals("Incorrect data", e.getMessage());
        }
    }
}
