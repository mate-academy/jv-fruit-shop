package core.basesyntax.service.implementations;

import core.basesyntax.dao.StorageDao;

public class ReportCreator {
    private static final String REPORT_TEMPLATE = "fruit,quantity";
    private StorageDao storageDao;

    public ReportCreator(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public String provideReport() {
        return REPORT_TEMPLATE + storageDao.toString();
    }
}
