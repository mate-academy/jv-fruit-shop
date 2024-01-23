package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file by path: " + filePath, e);
        }
    }

    @Override
    public void writeToFile(String fileName, String report) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Suggested path not found: " + fileName, e);
        }
    }
}
