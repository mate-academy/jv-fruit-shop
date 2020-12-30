package core.basesyntax.fruitoperation.strategy;

import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.report.ReportFormatter;
import core.basesyntax.report.ReportFormatterImpl;
import core.basesyntax.workwithfiles.impl.FileReader;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OperationStrategyImplTest {
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
    public void test5ReportFormatting_twoBalanced() {
        try {
            reportFormatter.createReport(
                    new FileReader("src/main/resources/test5_incorrect.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals("Incorrect operation!!! This fruit already has balance!",
                    e.getMessage());
        }
    }

    @Test
    public void test6ReportFormatting_notEnough() {
        try {
            reportFormatter.createReport(
                    new FileReader("src/main/resources/test6_incorrect.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals("Sorry, byt we haven't enough fruits", e.getMessage());
        }
    }

    @Test
    public void test7ReportFormatting_notBalanced() {
        try {
            reportFormatter.createReport(
                    new FileReader("src/main/resources/test7_incorrect.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals("Incorrect operation!!! This fruit does not have a balance!",
                    e.getMessage());
        }
    }
}
