package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface CsvFileReader {
    List<FruitTransaction> readTransactions(String fromFileName);
}
