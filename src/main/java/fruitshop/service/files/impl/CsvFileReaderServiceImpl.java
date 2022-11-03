package fruitshop.service.files.impl;

import fruitshop.service.files.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public String readFromFile(Path csvFilePath) {
        try {
            return String.join(LINE_SEPARATOR, Files.readAllLines(csvFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read from file: ", e);
        }
    }
}
