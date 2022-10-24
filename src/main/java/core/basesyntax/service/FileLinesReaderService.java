package core.basesyntax.service;

import java.util.List;

public interface FileLinesReaderService {
    List<String> readFile(String path);
}
