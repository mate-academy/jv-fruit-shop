package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import service.CsvFileWriterService;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    @Override
    public void writeToFile(String filePath, List<String> lines) {
        try {
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file by path: " + filePath, e);
        }
    }
}
