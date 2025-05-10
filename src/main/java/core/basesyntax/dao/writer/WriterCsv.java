package core.basesyntax.dao.writer;

import java.nio.file.Path;
import java.util.List;

public interface WriterCsv {
    void writeToFile(Path filePath, List<String> lines);
}
