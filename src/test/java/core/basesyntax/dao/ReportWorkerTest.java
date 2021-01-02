package core.basesyntax.dao;

import static org.junit.Assert.assertEquals;

import core.basesyntax.fileworker.InputOutputReport;
import java.time.LocalDate;
import org.junit.Test;

public class ReportWorkerTest {
    WarehouseImpl warehouse = new WarehouseImpl();

    @Test
    public void testReadFromReport() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("reportIn", warehouse);
        assertEquals(2, warehouse.getListFruits().size());
        assertEquals(152, warehouse.getAmountOfFruit("banana"));
        assertEquals(90, warehouse.getAmountOfFruit("apple"));
    }

    @Test(expected = RuntimeException.class)
    public void testReadFromError() {
        ReportWorker reportWorker = new ReportWorker();
        reportWorker.readFromReport("errorReport", warehouse);
    }

    @Test
    public void testWriteToReport() {
        WarehouseImpl warehouse = new WarehouseImpl();
        warehouse.addFruit("banana",140);
        warehouse.addFruit("apple", 40);
        ReportWorker reportWorker = new ReportWorker();
        InputOutputReport inputOutputReport = new InputOutputReport();
        reportWorker.writeToReport(warehouse);
        String expected = inputOutputReport.readReport("expected");
        String acctual = inputOutputReport.readReport("report.txt");
        assertEquals(expected, acctual);
    }
}

