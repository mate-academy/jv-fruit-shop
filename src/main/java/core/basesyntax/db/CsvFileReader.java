package core.basesyntax.db;

import java.util.List;

public interface CsvFileReader {
    List<String> read(String filePath);
}
