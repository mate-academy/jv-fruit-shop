package core.basesyntax.service.service;

import java.util.List;

public interface ReaderService {
    List<String> readFromFile(String pathToFile);
}
