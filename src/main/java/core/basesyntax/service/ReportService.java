package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;

public class ReportService {
    private static final String HEADER = "fruit,quantity";

    public String createReport(StorageDaoImpl stDao) {
        StringBuilder sb = new StringBuilder(HEADER + System.lineSeparator());
        stDao.getAllFruits().entrySet()
                .stream()
                .forEach(entry -> sb.append(entry.getKey() + "," + entry.getValue()
                        + System.lineSeparator()));
        return sb.toString();
    }
}
