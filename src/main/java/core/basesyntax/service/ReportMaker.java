package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;

public interface ReportMaker {
    String makeReport(StorageDao storageDao);
}
