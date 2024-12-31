package core.basesyntax.services;

import java.nio.file.Path;
import java.util.List;

public interface FileDataReader {
    List<String> readData(Path path);
}
