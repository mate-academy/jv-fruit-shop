package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : storageDao.getAll()) {
            report.append(entry.getKey().getFruit())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
