package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FruitReadFile implements ReadFile {

    @Override
    public List<String> readFromFile(String fileName) {
        Path filePath = Paths.get(fileName);
        List<String> linesFromFile;
        try {
            linesFromFile = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
        return linesFromFile;
    }
}
