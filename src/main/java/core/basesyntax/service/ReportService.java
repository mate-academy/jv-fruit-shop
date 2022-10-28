package core.basesyntax.service;

import core.basesyntax.db.StorageDao;

public interface ReportService {
    String getLines(StorageDao storageDao);
}
