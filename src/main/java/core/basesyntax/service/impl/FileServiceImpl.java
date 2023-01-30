package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String inputFileName) {
        try {
            return Files.readAllLines(Path.of(inputFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can`t read date from file " + inputFileName, e);
        }
    }

    @Override
    public void writeToFile(String fileName, String report) {
        try {
            Files.write(Path.of(fileName), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write result file", e);
        }
    }
}
