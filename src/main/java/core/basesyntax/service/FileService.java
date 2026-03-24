package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FileService {

    void saveToFile(Map<String, Integer> storageData, String fileName);

    List<FruitTransaction> loadFromFile(String fileName);
}
