package core.basesyntax.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReportServiceImplTest {
    private final StorageDao storageDao = new StorageDaoImpl();
    private final Map<String, Integer> storage = Storage.getFruits();
    private final ReportService reportService = new ReportServiceImpl(storageDao);

    @Test
    void getReport_Ok() {
        storage.put("banana", 150);
        storage.put("apple", 92);
        List<String> actual = reportService.getReport();
        List<String> expected = Arrays.asList("fruit,quantity", "banana,150", "apple,92");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getReport_emptyStorage_Ok() {
        List<String> actual = reportService.getReport();
        List<String> expected = List.of("fruit,quantity");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getReport_OneLine_oK() {
        storage.put("apple", 92);
        List<String> actual = reportService.getReport();
        List<String> expected = Arrays.asList("fruit,quantity", "apple,92");
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    void afterEach() {
        storage.clear();
    }
}
