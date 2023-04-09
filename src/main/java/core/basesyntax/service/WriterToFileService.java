package core.basesyntax.service;

import java.util.List;

public interface WriterToFileService {
    void writeToFile(List<String> list, String filePath);
}
