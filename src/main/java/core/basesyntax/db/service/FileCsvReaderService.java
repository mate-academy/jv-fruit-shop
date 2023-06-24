package core.basesyntax.db.service;

import java.util.List;

public interface FileCsvReaderService {
    List<String> readFromFile(String fileName);
}
