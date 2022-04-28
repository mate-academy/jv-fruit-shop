package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface FileWriterService {
    void write(Path path, List<String> report);
}
