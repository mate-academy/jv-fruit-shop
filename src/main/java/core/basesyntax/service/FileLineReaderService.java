package core.basesyntax.service;

import java.util.List;

public interface FileLineReaderService {
    List<String> readFile(String path);
}
