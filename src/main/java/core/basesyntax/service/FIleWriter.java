package core.basesyntax.service;

import java.nio.file.Path;

public interface FIleWriter {
    void writeFile(String scvFilePath, byte[] reportData);
}
