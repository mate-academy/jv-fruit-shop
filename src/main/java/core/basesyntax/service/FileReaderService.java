package core.basesyntax.service;

import java.io.File;

public interface FileReaderService {
    void read(File input, OperationStrategy operationStrategy);
}
