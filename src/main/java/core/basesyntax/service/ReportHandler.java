package core.basesyntax.service;

import core.basesyntax.db.StorageDao;

public interface ReportHandler {
    String makeReport(StorageDao storageDao);
}
