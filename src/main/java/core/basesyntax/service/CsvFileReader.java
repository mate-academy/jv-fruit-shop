package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvFileReader {
    List<FruitTransaction> readFromFile(String filePath);
}
