package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import java.util.List;

public interface ReportGenerator {
    List<String> generateReport(StorageDao storageDao);
}
