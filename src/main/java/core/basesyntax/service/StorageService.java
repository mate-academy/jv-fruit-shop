package core.basesyntax.service;

import java.util.Map;

public interface StorageService {
    void addFruit(String fruit, int quantity);

    int getFruitQuantity(String fruit);

    Map<String, Integer> getInventory();
}
