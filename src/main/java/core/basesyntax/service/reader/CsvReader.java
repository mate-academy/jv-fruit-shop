package core.basesyntax.service.reader;

import java.nio.file.Path;
import java.util.List;

public interface CsvReader {
    List<String> readFile(Path fileName);
}
