package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface FileService {
    List<String> readFromFile(Path path);

    boolean writeToFile(String report, Path path);
}
