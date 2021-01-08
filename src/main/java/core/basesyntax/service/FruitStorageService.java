package core.basesyntax.service;

import java.util.List;

public interface FruitStorageService {
    void saveFruitToStorage(List<String> data);

    String createReport();
}
