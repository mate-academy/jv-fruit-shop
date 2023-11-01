package core.basesyntax.dao.reads;

import java.util.List;

public interface CsvFileReader {
    List<String> read(String filePath);
}
