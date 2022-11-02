package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGeneratorSvc;

public class ReportGeneratorSvcImpl implements ReportGeneratorSvc {
    private static final String DELIMITER = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String HEADER = "fruit,quantity";
    private final StorageDao storage;

    public ReportGeneratorSvcImpl(StorageDao storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER);
        for (Fruit key : storage.getAllKeys()) {
            report.append(LINE_SEPARATOR).append(key.getName())
                    .append(DELIMITER).append(storage.get(key));
        }
        return report.toString();
    }
}
