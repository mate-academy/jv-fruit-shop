package core.basesyntax.service;

import java.io.File;

public interface FileWriterService {
    void writeToFile(File file, String text);
}
