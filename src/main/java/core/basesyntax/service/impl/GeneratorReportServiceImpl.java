package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.GeneratorReportService;
import java.util.List;

public class GeneratorReportServiceImpl implements GeneratorReportService {
    private final StorageDao storageDao;

    public GeneratorReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        List<String> fruits = storageDao.getAll();
        StringBuilder report = new StringBuilder();
        report.append("fruit").append(",").append("quantity").append(System.lineSeparator());
        for (String fruit : fruits) {
            report.append(fruit).append(",")
                    .append(storageDao.getAmount(fruit)).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
