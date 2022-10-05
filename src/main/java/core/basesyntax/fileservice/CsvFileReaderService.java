package core.basesyntax.fileservice;

import java.nio.file.Path;
import java.util.List;

public interface CsvFileReaderService {
    List<String> readFromFile(Path path);
}
