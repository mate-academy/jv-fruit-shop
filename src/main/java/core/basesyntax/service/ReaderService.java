package core.basesyntax.service;

import java.util.List;

public interface ReaderService {
    List<String> readDataFromFile(String pathToFile);
}
