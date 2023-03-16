package core.basesyntax.service.interfaces;

import java.util.List;

public interface CsvFileReader {
    List<String> readFromFile(String fileName);
}
