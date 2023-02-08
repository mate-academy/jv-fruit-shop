package core.service.impl;

import core.service.FileReaderService;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String pathToFile) {
        Path path = Path.of(pathToFile);
        try {
            return Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file " + path, e);
        }
    }
}
