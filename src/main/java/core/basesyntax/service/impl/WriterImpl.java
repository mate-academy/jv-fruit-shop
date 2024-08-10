package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterImpl implements Writer {
    private static final String REPORT_HEAD_LINE = "fruit,quantity";
    private static final char COMMA = ',';
    private StorageDao storageDao;

    public WriterImpl() {
        storageDao = new StorageDaoImpl();
    }

    @Override
    public void createReport(String reportPath) {
        File report = new File(reportPath);
        StringBuilder reportText = new StringBuilder(REPORT_HEAD_LINE);
        for (Map.Entry<String, Integer> fruit : storageDao.getAll()) {
            String fruitName = fruit.getKey();
            int quantity = fruit.getValue();
            reportText.append("\n").append(fruitName).append(COMMA).append(quantity);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath))) {
            writer.write(reportText.toString());
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to file: " + reportPath, e);
        }
    }
}
