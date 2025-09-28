package core.basesyntax.service;

import java.io.IOException;

public interface FileWriterService {
    void write(String report, String filePath) throws IOException;
}
