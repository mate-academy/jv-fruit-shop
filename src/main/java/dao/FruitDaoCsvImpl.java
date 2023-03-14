package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitDaoCsvImpl implements FruitDao {
    private final String filePath;

    public FruitDaoCsvImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void add(String content) {
        create(filePath);
        try {
            Files.write(Path.of(filePath), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to this file " + filePath);
        }
    }

    @Override
    public List<String> get() {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read information from this file " + filePath);
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
