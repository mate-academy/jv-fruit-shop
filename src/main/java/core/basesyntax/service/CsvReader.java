package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvReader {
    public List<FruitTransaction> readFromFile(String filePath);
}
