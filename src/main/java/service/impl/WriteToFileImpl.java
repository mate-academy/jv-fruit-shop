package service.impl;

import dao.StorageEnternce;
import dao.impl.EntrenceToStorage;
import service.WriteToFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class WriteToFileImpl implements WriteToFile {
    private StorageEnternce storage;

    public WriteToFileImpl() {
        storage = new EntrenceToStorage();
    }

    @Override
    public void writeToFile(String filePath, String splitter) {
        Path path = new File(filePath).toPath();
        try {
            Files.writeString(path,"fruit,quantity" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
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
