package core.basesyntax.reader;

import java.util.List;

public interface CsvFileReader {
    List<String> readFromCsv(String fileName);
}
