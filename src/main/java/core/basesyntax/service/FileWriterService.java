package core.basesyntax.service;

import java.util.List;

public interface FileWriterService {
    void writeToFile(String filename, List<String> data);
}
