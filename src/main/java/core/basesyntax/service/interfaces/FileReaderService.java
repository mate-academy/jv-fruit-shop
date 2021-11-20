package core.basesyntax.service.interfaces;

import java.nio.file.Path;
import java.util.List;

public interface FileReaderService {
    List<String> readLines(Path filePath);
}
