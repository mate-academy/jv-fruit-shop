package core.basesyntax.service;

import java.util.List;

public interface FileReaderService {
    List<List<String>> readFile(String filePath);
}
