package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CustomFileReader {
    List<FruitTransaction> readFile(String filePath);
}
