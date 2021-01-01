package core.basesyntax.report;

import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.fruitoperation.strategy.OperationStrategyImpl;
import core.basesyntax.reader.FileReader;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;

public class ReportFormatterImplTest extends TestCase {
    private static ReportFormatter reportFormatter;

    @Override
    public void setUp() throws Exception {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new OperationBalance());
        operationMap.put(Operations.P, new OperationPurchase());
        operationMap.put(Operations.R, new OperationReturn());
        operationMap.put(Operations.S, new OperationSupply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        reportFormatter = new ReportFormatterImpl(operationStrategy);
        super.setUp();
    }

    public void test1ReportFormatting_Ok() {

        String actual = reportFormatter.createReport(new FileReader("test1_correct.csv"));
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,90" + System.lineSeparator() + "banana,152";
        assertEquals(expected, actual);
    }

    public void test2ReportFormatting_Ok() {

        String actual = reportFormatter.createReport(new FileReader("test2_correct.csv"));
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,90" + System.lineSeparator() + "banana,152";
        assertEquals(expected, actual);
    }

    public void test3ReportFormatting_incorrectOperation() {
        try {
            reportFormatter.createReport(new FileReader("test3_incorrect.csv"));
        } catch (RuntimeException e) {
            assertEquals("Incorrect data", e.getMessage());
        }
    }

    public void test4ReportFormatting_operationDontPass() {
        try {
            reportFormatter.createReport(new FileReader("test4_incorrect.csv"));
        } catch (RuntimeException e) {
            assertEquals("Incorrect data", e.getMessage());
        }
    }

    public void test5ReportFormatting_twoBalanced() {
        try {
            reportFormatter.createReport(new FileReader("test5_incorrect.csv"));
        } catch (RuntimeException e) {
            assertEquals("Incorrect operation!!! This fruit also balanced!", e.getMessage());
        }
    }

    public void test6ReportFormatting_notEnough() {
        try {
            reportFormatter.createReport(new FileReader("test6_incorrect.csv"));
        } catch (RuntimeException e) {
            assertEquals("Sorry, byt we haven't enough fruits", e.getMessage());
        }
    }

    public void test7ReportFormatting_notBalanced() {
        try {
            reportFormatter.createReport(new FileReader("test7_incorrect.csv"));
        } catch (RuntimeException e) {
            assertEquals("Incorrect operation!!! This fruit not balanced!", e.getMessage());
        }
    }
}
