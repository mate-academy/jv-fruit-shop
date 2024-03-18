package core.basesyntax.service;

import java.util.List;

public interface WriterService {
    void writeData(String path, List<String[]> data);
}
