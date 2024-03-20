package core.basesyntax.service;

import java.util.List;

public interface WriterService {
    void writeToFile(List<String> data, String filePath);
}
