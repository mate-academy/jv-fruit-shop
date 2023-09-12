package core.basesyntax.service.reader;

import java.util.List;

public interface CsvFileReader {
    List<String> readDataFromFile(String path);
}
