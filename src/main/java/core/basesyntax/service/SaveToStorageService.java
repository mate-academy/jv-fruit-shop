package core.basesyntax.service;

import java.util.List;

public interface SaveToStorageService {
    void storeAll(List<String> linesFromFile);
}
