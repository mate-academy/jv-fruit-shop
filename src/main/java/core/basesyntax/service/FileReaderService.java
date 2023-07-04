package core.basesyntax.service;

import core.basesyntax.service.impl.FileReaderResult;
import java.io.IOException;

public interface FileReaderService {
    public FileReaderResult readFile(String inputFileName) throws IOException;
}
