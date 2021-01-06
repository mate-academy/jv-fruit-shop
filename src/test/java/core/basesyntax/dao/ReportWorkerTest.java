package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.Procedure;
import core.basesyntax.service.ReportWorker;
import core.basesyntax.service.fileworker.InputOutputReport;
import core.basesyntax.strategy.Balance;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.Purchase;
import core.basesyntax.strategy.Return;
import core.basesyntax.strategy.Supply;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReportWorkerTest {
    private static Map<Procedure, OperationStrategy> operationStrategyMap;
    private static WarehouseImpl warehouseTest;
    private static InputOutputReport inputOutputReport;

    @BeforeClass
    public static void setup() {
        inputOutputReport = new InputOutputReport();
        warehouseTest = new WarehouseImpl();
        operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Procedure.Balance, new Balance());
        operationStrategyMap.put(Procedure.Purchase, new Purchase());
        operationStrategyMap.put(Procedure.Return, new Return());
        operationStrategyMap.put(Procedure.Supply, new Supply());
    }

    @After
    public void storeClear() {
        Warehouse warehouse = new WarehouseImpl();
        warehouse.getListItems().clear();
    }

    @Test
    public void testReadFromReport() {
        ReportWorker reportWorker = new ReportWorker();
        String report = inputOutputReport.readReport("reportIn");
        reportWorker.readFromReport(report, operationStrategyMap);
        assertEquals(152, warehouseTest.getAmountOfItem(new Fruit("banana")));
        assertEquals(90, warehouseTest.getAmountOfItem(new Fruit("apple")));
    }

    @Test(expected = RuntimeException.class)
    public void testReadError() {
        ReportWorker reportWorker = new ReportWorker();
        String report = inputOutputReport.readReport("noFind");
        reportWorker.readFromReport(report, operationStrategyMap);
    }

    @Test(expected = RuntimeException.class)
    public void testReadFromError() {
        ReportWorker reportWorker = new ReportWorker();
        String report = inputOutputReport.readReport("errorReport");
        reportWorker.readFromReport(report, operationStrategyMap);
    }

    @Test(expected = RuntimeException.class)
    public void testValidationError() {
        ReportWorker reportWorker = new ReportWorker();
        String report = inputOutputReport.readReport("test2");
        reportWorker.readFromReport(report, operationStrategyMap);
    }

    @Test
    public void testWriteToReport() {
        WarehouseImpl warehouse = new WarehouseImpl();
        warehouse.addItem(new Fruit("banana"),140);
        warehouse.addItem(new Fruit("apple"), 40);
        ReportWorker reportWorker = new ReportWorker();
        InputOutputReport inputOutputReport = new InputOutputReport();
        inputOutputReport.writeReport(reportWorker.writeToReport(), "report.txt");
        String expected = "fruit,quantity "
                + "banana,140 "
                + "apple,40 ";
        String acctual = inputOutputReport.readReport("report.txt");
        assertEquals(expected, acctual);
    }

    @Test(expected = RuntimeException.class)
    public void testWriteToError() {
        InputOutputReport inputOutputReport = new InputOutputReport();
        inputOutputReport.writeReport("", "");
    }
}

