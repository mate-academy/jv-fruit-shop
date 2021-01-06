package core.basesyntax;

import core.basesyntax.model.Operations;
import core.basesyntax.service.impl.FruitStorageServiceImpl;
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

public class ReportTests extends TestCase {
    private static FruitStorageServiceImpl reportCreator;

    @Override
    public void setUp() throws Exception {
        Map<Operations, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new BalanceHandler());
        operationMap.put(Operations.P, new PurchaseHandler());
        operationMap.put(Operations.R, new ReturnHandler());
        operationMap.put(Operations.S, new SupplyHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        reportCreator = new FruitStorageServiceImpl(operationStrategy);
        super.setUp();
    }

    @Test
    public void test1Report_Ok() {
        reportCreator.saveFruitToStorage("src/test/resources/test1_correct.csv");
        String actual = reportCreator.createReport();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator() + "apple,90";
        assertEquals(expected, actual);
    }

    @Test
    public void test2Report_Ok() {
        reportCreator.saveFruitToStorage("src/test/resources/test2_correct.csv");
        String actual = reportCreator.createReport();
        String expected = "fruit,quantity" + System.lineSeparator()
                + "banana,152" + System.lineSeparator() + "apple,90";
        assertEquals(expected, actual);
    }

    @Test
    public void test3Report_notOk() {
        try {
            reportCreator.saveFruitToStorage("src/test/resources/test3_incorrect.csv");
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "File was not found");
        }
    }
}
