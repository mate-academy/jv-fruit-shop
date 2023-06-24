package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read date from file " + fileName, e);
        }
    }

    @Override
    public void writeToFile(String fileName, String text) {
        try {
            Files.write(Path.of(fileName), text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write result file" + fileName, e);
        }
    }
}
