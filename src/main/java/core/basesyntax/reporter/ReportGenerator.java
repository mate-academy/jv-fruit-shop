package core.basesyntax.reporter;

import core.basesyntax.dao.StorageDao;

public interface ReportGenerator {
    String createReport(StorageDao storageDao);
}
