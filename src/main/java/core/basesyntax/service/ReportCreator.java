package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;

public interface ReportCreator {
    String createReport(StorageDao storageDao);
}
