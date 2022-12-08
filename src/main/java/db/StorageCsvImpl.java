package db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class StorageCsvImpl implements Storage {
    private static final Path FOLDERS_PATH = Paths.get("src/main/resources");
    private static final Path DATA_PATH = Paths.get("src/main/resources/database.Csv");

    public StorageCsvImpl() {
        if (Files.exists(DATA_PATH)) {
            try {
                Files.writeString(DATA_PATH, "type,fruit,quantity");
            } catch (IOException e) {
                throw new RuntimeException("Can't write to storage file", e);
            }
        }
    }

    private void createDataBase() {
        try {
            Files.createDirectories(FOLDERS_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Can't create folders", e);
        }
        try {
            Files.createFile(DATA_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file for storage", e);
        }
        try {
            Files.writeString(DATA_PATH, "type,fruit,quantity");
        } catch (IOException e) {
            throw new RuntimeException("Can't write to storage file", e);
        }
    }

    @Override
    public List<String> getData() {
        if (!Files.exists(DATA_PATH)) {
            createDataBase();
        }
        try {
            return Files.readAllLines(DATA_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from database", e);
        }
    }

    @Override
    public boolean addData(String stringFruitTransaction) {
        if (!Files.exists(DATA_PATH)) {
            createDataBase();
        }
        try {
            Files.writeString(DATA_PATH, stringFruitTransaction, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write transaction to storage file", e);
        }
        return true;
    }
}
