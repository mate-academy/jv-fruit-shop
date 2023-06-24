package core.basesyntax.service.interfaces;

import java.util.List;

public interface CsvFileReaderService {
    List<String> readFromFile(String fileName);
}
