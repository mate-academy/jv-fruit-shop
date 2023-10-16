package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.service.impl.ReportServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportServiceTest {

    private ReportService reportService;

    @AfterEach
    void afterEachTest() {
        Storage.storage.clear();
    }

    @BeforeEach
    void setUp() {
        reportService = new ReportServiceImpl();
    }

    @Test
    void createReport_validReport_ok() {
        Storage.storage.put("banana", 20);
        Storage.storage.put("apple", 10);
        Storage.storage.put("watermelon", 15);
        String exceptedReport = ("fruit,quantity" + System.lineSeparator()
                + "banana,20" + System.lineSeparator()
                + "apple,10" + System.lineSeparator()
                + "watermelon,15" + System.lineSeparator());
        String actualReport = reportService.createReport();
        assertEquals(exceptedReport, actualReport);
    }
}