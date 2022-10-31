package core.basesyntax.service;

import java.util.List;

public interface ReaderService {
    // use relative path
    List<String> readFromFile(String filePath);
}
