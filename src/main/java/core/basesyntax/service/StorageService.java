package core.basesyntax.service;

import java.util.Map;

public interface StorageService {
    void addFruit(String fruit, int quantity);

    void removeFruit(String fruit, int quantity);

    Map<String, Integer> getAllFruits();
}
