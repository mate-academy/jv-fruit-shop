package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface FileWriter {
    void saveDataToFile(Path path, List<String> data);
}
