package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.FruitDB;
import core.basesyntax.db.HashMapFruitDB;
import core.basesyntax.model.ReportRecord;
import core.basesyntax.service.ReportService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportServiceImplTest {
    private static final String APPLE = "apple";
    private static final String BANANA = "banana";
    private FruitDB db;
    private ReportService reportService;

    @BeforeEach
    void setUp() {
        db = new HashMapFruitDB();
        reportService = new ReportServiceImpl(db);
    }

    @Test
    void generate_emptyDatabase_success() {
        List<ReportRecord> list = reportService.generate();
        assertEquals(0, list.size());
    }

    @Test
    void generate_databaseContainsNull_success() {
        db.setQuantity(null, 5);
        db.setQuantity(APPLE, 10);
        List<ReportRecord> list = reportService.generate();
        assertEquals(2, list.size());
    }

    @Test
    void generate_databaseContainsData_success() {
        db.setQuantity(BANANA, 3);
        db.setQuantity(APPLE, 10);
        List<ReportRecord> list = reportService.generate();
        assertEquals(2, list.size());
    }

    @Test
    void generate_databaseContainsNegativeQuantity_success() {
        db.setQuantity(APPLE, -10);
        List<ReportRecord> list = reportService.generate();
        assertEquals(1, list.size());
    }

    @Test
    void generate_whenDatabaseContainZeroQuantities_thenTheyAreOmitted() {
        db.setQuantity(APPLE, 0);
        db.setQuantity(BANANA, 0);
        List<ReportRecord> list = reportService.generate();
        assertEquals(0, list.size());
    }
}
