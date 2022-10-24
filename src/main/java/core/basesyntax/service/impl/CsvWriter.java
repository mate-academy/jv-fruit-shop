package core.basesyntax.service.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.service.WriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CsvWriter implements WriterService {
    private static final String TITLE_LINE = "fruit,quantity";
    private final StorageDao storageDao;

    public CsvWriter(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void saveFromStorageToFile(String filePath) {
        Path path = Path.of(filePath);
        if (!Files.isReadable(path)) {
            createNewFile(path);
        }

        writeTitleToFile(path);
        storageDao.getStorageStream()
                .forEach(s -> writeLineToFile(path, getLineFromStorage(s.getKey())));
    }

    private void writeLineToFile(Path path, String line) {
        try {
            Files.write(path, line.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getLineFromStorage(String key) {
        return key + "," + storageDao.getValue(key) + System.lineSeparator();
    }

    private void writeTitleToFile(Path path) {
        writeLineToFile(path, TITLE_LINE + System.lineSeparator());
    }

    private void createNewFile(Path filePath) {
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can`t found or create file", e);
        }
    }
}
