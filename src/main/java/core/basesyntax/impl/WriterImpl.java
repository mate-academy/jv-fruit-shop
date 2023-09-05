package core.basesyntax.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.util.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriterImpl implements Writer {
    private static final String BASE_DELIMITER = "=";
    private static final String FILE_DELIMITER = ",";
    private static final String TITLE_OF_REPORT = "fruit,quantity";
    private static final String FILE_PATH_TO = "src/main/resources/fileTo.csv";
    private final StorageDao storageDao;

    public WriterImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void writeListToFile() {
        List<String> report = storageDao.getAllFruits()
                .stream()
                .map(s -> s.replace(BASE_DELIMITER, FILE_DELIMITER))
                .toList();
        File file = new File(FILE_PATH_TO);
        List<String> lines = new ArrayList<>();
        lines.add(TITLE_OF_REPORT);
        lines.addAll(report);
        for (String line : lines) {
            try (BufferedWriter bufferedWriter
                         = new BufferedWriter(new FileWriter(file, true))) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());

            } catch (IOException e) {
                throw new RuntimeException("Can't write report to file: " + file, e);
            }
        }
    }
}
