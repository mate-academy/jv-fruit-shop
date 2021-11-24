package core.basesyntax.service.impl;

import core.basesyntax.bd.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        Map<Fruit, Integer> report = storageDao.getAll();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity\n");
        for (Map.Entry<Fruit, Integer> entry : report.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return reportBuilder.toString();
    }
}
