package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface ReaderService {
    List<String> readFile(Path path);
}
