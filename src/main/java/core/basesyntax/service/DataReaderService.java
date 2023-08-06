package core.basesyntax.service;

import java.util.List;

public interface DataReaderService {
    List<String> readFromFile(String pathToFile);
}
