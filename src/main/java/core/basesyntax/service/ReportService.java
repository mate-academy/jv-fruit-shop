package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;

public class ReportService {
    public String createReport(StorageDaoImpl stDao) {
        StringBuilder sb = new StringBuilder("fruit,quantity\n");
        stDao.getAllFruits().entrySet()
                .stream()
                .forEach(entry -> sb.append(entry.getKey() + "," + entry.getValue()
                        + System.lineSeparator()));
        return sb.toString();
    }
}
