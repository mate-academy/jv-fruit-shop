package core.basesyntax.service;

import java.io.IOException;

public interface WriterService {
    void writeToFile(String pathToFile, String report) throws IOException;
}
