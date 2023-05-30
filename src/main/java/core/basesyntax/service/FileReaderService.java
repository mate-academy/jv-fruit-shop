package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(String filePath);
}
