package core.basesyntax.service.writer;

import java.nio.file.Path;
import java.util.List;

public interface CsvWriter {
    void writeToFile(Path filePath, List<String> info);
}
