package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        List<String> fruits = storageDao.getAll();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit").append(",").append("quantity").append(System.lineSeparator());
        for (String fruit : fruits) {
            reportBuilder.append(fruit).append(",")
                    .append(storageDao.getAmount(fruit)).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
