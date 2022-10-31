package service.impl;

import dao.StorageEnternce;
import dao.impl.EntrenceToStorage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import service.WriteToFile;

public class WriteToFileImpl implements WriteToFile {
    private StorageEnternce storage;

    public WriteToFileImpl() {
        storage = new EntrenceToStorage();
    }

    @Override
    public void writeToFile(String filePath, String splitter) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Path path = file.toPath();
        try {
            Files.writeString(path,"fruit,quantity" + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Can't find such file" + filePath);
        }
        storage.getStorage().entrySet().stream()
                .map(e -> e.getKey() + splitter + e.getValue() + System.lineSeparator())
                .forEach(s -> {
                    try {
                        Files.writeString(path, s, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        throw new RuntimeException("Can't find such file" + filePath);
                    }
                });
    }
}
