package core.basesyntax.service.impl;

import java.util.List;

public interface FileReader {
    List<FruitTransaction> readFromFile(String pathToFile);
}
