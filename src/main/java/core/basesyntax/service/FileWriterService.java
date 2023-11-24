package core.basesyntax.service;

import java.util.List;

public interface FileWriterService {
    void writeToFile(String filePath, List<String[]> data);
}
