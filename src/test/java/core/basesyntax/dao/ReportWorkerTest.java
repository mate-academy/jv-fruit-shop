package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.ReportWorker;
import core.basesyntax.service.fileworker.InputOutputReport;
import org.junit.Test;

public class ReportWorkerTest {
    WarehouseImpl warehouseTest = new WarehouseImpl();

    @Test
    public void testReadFromReport() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("reportIn", warehouseTest);
        assertEquals(152, warehouseTest.getAmountOfItem("banana"));
        assertEquals(90, warehouseTest.getAmountOfItem("apple"));
    }

    @Test(expected = RuntimeException.class)
    public void testReadError() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("noFind", warehouseTest);
    }

    @Test(expected = RuntimeException.class)
    public void testReadFromError() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("errorReport", warehouseTest);
    }

    @Test(expected = RuntimeException.class)
    public void testValidationError() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("test2", warehouseTest);
    }

    @Test
    public void testWriteToReport() {
        WarehouseImpl warehouse = new WarehouseImpl();
        warehouse.addItem("banana",140);
        warehouse.addItem("apple", 40);
        ReportWorker reportWorker = new ReportWorker();
        InputOutputReport inputOutputReport = new InputOutputReport();
        reportWorker.writeToReport(warehouse);
        String expected = "fruit,quantity "
                + "banana,140 "
                + "apple,40 ";
        String acctual = inputOutputReport.readReport("report.txt");
        assertEquals(expected, acctual);
    }
}

