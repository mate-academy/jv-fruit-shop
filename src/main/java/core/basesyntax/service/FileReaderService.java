package core.basesyntax.service;

import java.util.List;

public interface FileReaderService {
    List<FruitTransaction> readFromFile(String pathToFile);
}
