package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;

public class ReportService {
    private static final String HEADER = "fruit,quantity";
    private StorageDaoImpl storageDao;

    public ReportService(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    public String createReport() {
        StringBuilder sb = new StringBuilder(HEADER + System.lineSeparator());
        storageDao.getAllFruits().entrySet()
                .stream()
                .forEach(entry -> sb.append(entry.getKey() + "," + entry.getValue()
                        + System.lineSeparator()));
        return sb.toString();
    }
}
