package core.basesyntax.fileServise;

import java.util.List;

public interface CsvFileReader {
    List<String> getTransactionsFromFile(String fileName);
}
