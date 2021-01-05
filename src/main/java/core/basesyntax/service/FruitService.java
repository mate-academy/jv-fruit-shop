package core.basesyntax.service;

import java.util.List;

public interface FruitService {
    void saveToStorage(List<String> rows);

    String getFromStorage();
}
