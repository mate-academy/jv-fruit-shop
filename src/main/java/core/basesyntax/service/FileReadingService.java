package core.basesyntax.service;

import java.util.List;

public interface FileReadingService {
    List<String> readFromFile(String pathToFile);
}
