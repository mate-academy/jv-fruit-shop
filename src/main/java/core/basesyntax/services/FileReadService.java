package core.basesyntax.services;

import java.util.List;

public interface FileReadService {
    List<String> readFromFile(String filePath);
}
