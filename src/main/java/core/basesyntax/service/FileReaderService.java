package core.basesyntax.service;

import core.basesyntax.service.impl.FileReaderResult;

public interface FileReaderService {
    FileReaderResult readFile(String inputFileName);
}
