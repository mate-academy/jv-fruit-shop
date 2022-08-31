package core.basesyntax.service;

import java.nio.file.Path;
import java.util.List;

public interface WriterService {
    void writeTo(Path path, List<String> list);
}
