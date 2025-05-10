package core.basesyntax.services;

import java.util.Map;

public interface StorageService {
    void add(String fruit, int quantity);

    void remove(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getAll();
}
