package core.basesyntax.servicesimpl;

import core.basesyntax.services.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    @Override
    public List<String> readFromFile(Path filePath) {
        List<String> records = Collections.emptyList();
        try {
            records = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + filePath.getFileName() + e);
        }
        return records;
    }
}
