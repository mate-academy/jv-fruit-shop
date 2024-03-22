package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface FileReader {
    List<String> readFromFile(Path path);
}
