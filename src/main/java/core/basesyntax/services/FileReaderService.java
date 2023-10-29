package core.basesyntax.services;

import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(String fileName);
}
