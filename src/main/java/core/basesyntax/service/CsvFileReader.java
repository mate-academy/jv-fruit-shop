package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvFileReader extends FruitTransactionReader {
    List<FruitTransaction> readFromFile(String filePath);
}
