package core.basesyntax;

import java.io.IOException;
import java.util.List;

public interface CsvFileReader {
    List<Transaction> readTransactionsFile() throws IOException;
}
