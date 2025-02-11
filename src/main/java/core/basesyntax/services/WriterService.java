package core.basesyntax.services;

import java.util.List;

public interface WriterService {
    void write(String filePath, List<String> data);
}
