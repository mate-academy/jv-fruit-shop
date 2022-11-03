package core.basesyntax.service;

import java.util.List;

public interface FileCsvReader {
    List<String> readFromFile(String filePath);
}
