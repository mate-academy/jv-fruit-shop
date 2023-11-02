package core.basesyntax.services.reads;

import java.util.List;

public interface CsvFileReader {
    List<String> read(String filePath);
}
