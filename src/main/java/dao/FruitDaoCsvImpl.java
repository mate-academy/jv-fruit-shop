package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitDaoCsvImpl implements FruitDao {
    private final String readFromFilePath;
    private final String writeToFilePath;

    public FruitDaoCsvImpl(String readFromFilePath, String writeToFilePath) {
        this.readFromFilePath = readFromFilePath;
        this.writeToFilePath = writeToFilePath;
    }

    @Override
    public void add(String content) {
        create(writeToFilePath);
        try {
            Files.write(Path.of(writeToFilePath), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to this file " + writeToFilePath);
        }
    }

    @Override
    public List<String> get() {
        try {
            return Files.readAllLines(Path.of(readFromFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read information from this file " + readFromFilePath);
        }
    }

    private Path create(String fileName) {
        try {
            return Files.createFile(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't create file in this folder " + fileName);
        }
    }
}
