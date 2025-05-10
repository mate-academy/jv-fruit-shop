package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEAD_LINE = "fruit,quantity";
    private static final char COMMA = ',';
    private StorageDao storageDao;

    public ReportGeneratorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String generateReport() {
        StringBuilder reportText = new StringBuilder(REPORT_HEAD_LINE);
        for (Map.Entry<String, Integer> fruit : storageDao.getAll()) {
            String fruitName = fruit.getKey();
            int quantity = fruit.getValue();
            reportText.append(System.lineSeparator()).append(fruitName)
                    .append(COMMA).append(quantity);
        }
        return reportText.toString();
    }
}
