package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGeneratorService;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String DELIMITER = ",";
    private static final String HEADER = "fruit,quantity";
    private final StorageDao storage;

    public ReportGeneratorServiceImpl(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER);
        for (Fruit key : storage.getAllKeys()) {
            report.append(System.lineSeparator()).append(key.getName())
                    .append(DELIMITER).append(storage.get(key));
        }
        return report.toString();
    }
}
