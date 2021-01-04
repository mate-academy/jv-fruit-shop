package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;

import core.basesyntax.fileworker.InputOutputReport;
import org.junit.Test;

public class ReportWorkerTest {
    WarehouseImpl warehouse = new WarehouseImpl();

    @Test
    public void testReadFromReport() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("reportIn", warehouse);
        assertEquals(2, warehouse.getListItems().size());
        assertEquals(152, warehouse.getAmountOfItem("banana"));
        assertEquals(90, warehouse.getAmountOfItem("apple"));
    }

    @Test(expected = RuntimeException.class)
    public void testReadError() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("noFind", warehouse);
    }

    @Test(expected = RuntimeException.class)
    public void testReadFromError() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("errorReport", warehouse);
    }

    @Test(expected = RuntimeException.class)
    public void testValidationError() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("test2", warehouse);
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

