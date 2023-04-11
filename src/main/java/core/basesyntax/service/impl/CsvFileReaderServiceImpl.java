package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileReaderService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file" + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + filePath);
        }
    }
}
