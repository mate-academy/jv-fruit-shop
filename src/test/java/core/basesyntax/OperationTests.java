package core.basesyntax;

import core.basesyntax.model.Operations;
import core.basesyntax.service.impl.ReadFromCsvFileImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class OperationTests extends TestCase {
    private static ReportCreatorImpl reportCreator;

    @Override
    public void setUp() throws Exception {
        Map<Operations, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new BalanceHandler());
        operationMap.put(Operations.P, new PurchaseHandler());
        operationMap.put(Operations.R, new ReturnHandler());
        operationMap.put(Operations.S, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        reportCreator = new ReportCreatorImpl(operationStrategy);
        super.setUp();
    }

    @Test
    public void testCorrectBalance_Ok() {
        String actual = reportCreator.createReport(
                new ReadFromCsvFileImpl("src/test/resources/test_correctBalance.csv"));
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,20" + System.lineSeparator() + "apple,100";
        assertEquals(expected, actual);
    }

    @Test
    public void testCorrectSupply_Ok() {
        String actual = reportCreator.createReport(
                new ReadFromCsvFileImpl("src/test/resources/test_correctSupply.csv"));
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,100" + System.lineSeparator() + "apple,50";
        assertEquals(expected, actual);
    }

    @Test
    public void testIncorrectValueOfSupply_NotOk() {
        try {
            reportCreator.createReport(
                    new ReadFromCsvFileImpl("src/test/resources/test_incorrectValueOfSupply.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "Incorrect data");
        }
    }

    @Test
    public void testCorrectReturn_Ok() {
        String actual = reportCreator.createReport(
                new ReadFromCsvFileImpl("src/test/resources/test_correctReturn.csv"));
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,30" + System.lineSeparator() + "apple,110";
        assertEquals(expected, actual);
    }

    @Test
    public void testIncorrectValueOfReturn_NotOk() {
        try {
            reportCreator.createReport(
                    new ReadFromCsvFileImpl("src/test/resources/"
                            + "test_incorrectValueOfPurchase.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "Incorrect data");
        }
    }

    @Test
    public void testCorrectPurchase_Ok() {
        String actual = reportCreator.createReport(
                new ReadFromCsvFileImpl("src/test/resources/"
                        + "test_correctPurchase.csv"));
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,10" + System.lineSeparator() + "apple,70";
        assertEquals(expected, actual);
    }

    @Test
    public void testIncorrectValueOfPurchase_NotOk() {
        try {
            reportCreator.createReport(
                    new ReadFromCsvFileImpl("src/test/resources/"
                            + "test_incorrectValueOfPurchase.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "Incorrect data");
        }
    }

    @Test
    public void testIncorrectValueOfOperation_NotOk() {
        try {
            reportCreator.createReport(
                    new ReadFromCsvFileImpl("src/test/resources/"
                            + "test_incorrectValueOfOperation.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "Incorrect data");
        }
    }

    @Test
    public void testIncorrectFormat_NotOk() {
        try {
            reportCreator.createReport(
                    new ReadFromCsvFileImpl("src/test/resources/test_IncorrectFormat.csv"));
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "Incorrect data");
        }
    }
}
