package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportGenerationService;
import java.util.Map;

public class ReportGenerationServiceImpl implements ReportGenerationService {
    private final StorageDao storageDao;

    public ReportGenerationServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : storageDao.getData().entrySet()) {
            builder.append(System.lineSeparator()).append(entry.getKey())
                    .append(",").append(entry.getValue());
        }
        return builder.toString();
    }
}
