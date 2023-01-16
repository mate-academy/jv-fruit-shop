package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface FileReadService {
    List<String> readFromFile(Path path);
}
