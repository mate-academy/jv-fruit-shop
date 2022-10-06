package core.basesyntax.fileservice;

import java.util.List;

public interface CsvFileReaderService {
    List<String> readFromFile(String path);
}
