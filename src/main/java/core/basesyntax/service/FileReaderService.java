package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface FileReaderService {
    List<String> read(Path path);
}
