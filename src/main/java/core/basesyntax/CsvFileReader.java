package core.basesyntax;

import java.util.List;

public interface CsvFileReader {
    List<Transaction> readTransactions();
}
