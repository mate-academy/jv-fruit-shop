package core.basesyntax.service.impl;

import core.basesyntax.service.ImportDataService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class  ImportDataServiceImpl implements ImportDataService {
    @Override
    public List<String> ReaderFromCsvFile(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + path);
        }
    }
}
