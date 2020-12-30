package core.basesyntax.report;

import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.fruitoperation.strategy.OperationStrategyImpl;
import core.basesyntax.workwithfiles.impl.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportFormatterImplTest {
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
    public void test1ReportFormatting_Ok() {
        String actual = reportFormatter.createReport(
                new FileReader("src/main/resources/test1_correct.csv"));
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,90" + System.lineSeparator() + "banana,152";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2ReportFormatting_Ok() {
        String actual = reportFormatter.createReport(
                new FileReader("src/main/resources/test2_correct.csv"));
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,90" + System.lineSeparator() + "banana,152";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3ReportFormatting_incorrectOperation() {
        try {
            reportFormatter.createReport(
                    new FileReader("src/main/resources/test3_incorrect.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals("Incorrect data", e.getMessage());
        }
    }

    @Test
    public void test4ReportFormatting_operationDontPass() {
        try {
            reportFormatter.createReport(
                    new FileReader("src/main/resources/test4_incorrect.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals("Incorrect data", e.getMessage());
        }
    }
}
