package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.service.impl.ReportServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
}
