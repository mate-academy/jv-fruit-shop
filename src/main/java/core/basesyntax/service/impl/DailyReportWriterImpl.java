package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.DailyReportWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DailyReportWriterImpl implements DailyReportWriter {
    private final StorageDao storageDao;

    public DailyReportWriterImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void write(String toFilePath) {
        try (FileWriter writer = new FileWriter(toFilePath)) {
            writer.write("fruit,quantity");
            for (Fruit fruit : storageDao.getAllFruits()) {
                writer.write("\n");
                writer.write(fruit.getFruitType());
                writer.write(",");
                writer.write(String.valueOf(fruit.getFruitQuantity()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file " + toFilePath);
        }
    }
}
