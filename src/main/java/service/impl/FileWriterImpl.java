package service.impl;

import dao.StorageDao;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    private StorageDao storageDao;

    public FileWriterImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void write(String fileName) {
        try {
            Files.write(Path.of(fileName), report().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName);
        }
    }

    private String report() {
        return new StringBuilder("fruit,quantity")
                .append(storageDao.getSet().stream().map(e -> new StringBuilder("\n")
                        .append(e.getKey().getName())
                        .append(",")
                        .append(e.getValue())).collect(Collectors.joining()))
                .toString();
    }
}
