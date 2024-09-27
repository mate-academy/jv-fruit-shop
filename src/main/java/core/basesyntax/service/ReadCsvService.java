package core.basesyntax.service;

import java.util.List;

public interface ReadCsvService {
    List<String> readFromFile(String filePath);
}
