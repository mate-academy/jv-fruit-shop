package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FruitDaoCsvImpl implements FruitDao {
    private final String readFromFileName;
    private final String writeToFileName;

    public FruitDaoCsvImpl(String readFromFileName, String writeToFileName) {
        this.readFromFileName = readFromFileName;
        this.writeToFileName = writeToFileName;
    }

    @Override
    public void add(String content) {
        create(writeToFileName);
        try {
            Files.write(Path.of(writeToFileName), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write information to this file " + writeToFileName);
        }
    }

    @Override
    public List<String> get() {
        try {
            return Files.readAllLines(Path.of(readFromFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read information from this file " + readFromFileName);
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
