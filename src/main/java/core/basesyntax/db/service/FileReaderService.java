package core.basesyntax.db.service;

import java.util.List;

public interface FileReaderService {
    List<String> readFromFile(String fileName);
}
