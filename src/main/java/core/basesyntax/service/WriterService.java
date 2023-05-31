package core.basesyntax.service;

import java.util.List;

public interface WriterService {
    void writeDataToFile(String fileName, List<String> data);
}
