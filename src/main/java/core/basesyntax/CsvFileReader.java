package core.basesyntax;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface CsvFileReader {
    List<Transaction> readTransactions();
}
