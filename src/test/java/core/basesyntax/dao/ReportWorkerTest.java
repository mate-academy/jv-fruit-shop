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
import org.junit.Test;

public class ReportWorkerTest {
    Map<Procedure, OperationStrategy> operationStrategyMap = new HashMap<>();
    WarehouseImpl warehouseTest = new WarehouseImpl();
    InputOutputReport inputOutputReport = new InputOutputReport();

    @Test
    public void testReadFromReport() {
        operationStrategyMap.put(Procedure.Balance, new Balance());
        operationStrategyMap.put(Procedure.Purchase, new Purchase());
        operationStrategyMap.put(Procedure.Return, new Return());
        operationStrategyMap.put(Procedure.Supply, new Supply());
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
        operationStrategyMap.put(Procedure.Balance, new Balance());
        operationStrategyMap.put(Procedure.Purchase, new Purchase());
        operationStrategyMap.put(Procedure.Return, new Return());
        operationStrategyMap.put(Procedure.Supply, new Supply());
        ReportWorker reportWorker = new ReportWorker();
        String report = inputOutputReport.readReport("errorReport");
        reportWorker.readFromReport(report, operationStrategyMap);
    }

    @Test(expected = RuntimeException.class)
    public void testValidationError() {
        operationStrategyMap.put(Procedure.Balance, new Balance());
        operationStrategyMap.put(Procedure.Purchase, new Purchase());
        operationStrategyMap.put(Procedure.Return, new Return());
        operationStrategyMap.put(Procedure.Supply, new Supply());
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
        reportWorker.writeToReport();
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

