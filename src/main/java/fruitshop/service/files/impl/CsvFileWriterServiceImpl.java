package fruitshop.service.files.impl;

import fruitshop.service.files.CsvFileWriterService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    public void writeToFile(Path targetFile, String data) {
        try {
            Files.writeString(targetFile, data);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file: ", e);
        }
    }
}
