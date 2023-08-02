package core.basesyntax.service;

import java.io.File;

public interface FileWriterService {
    void writeToFile(String report, File reportFile);
}
