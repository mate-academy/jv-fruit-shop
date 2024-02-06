package core.basesyntax.fileservise;

import java.util.List;

public interface CsvFileReader {
    List<String> getTransactionsFromFile(String fileName);
}
