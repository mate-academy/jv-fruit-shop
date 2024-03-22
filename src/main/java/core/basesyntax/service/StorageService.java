package core.basesyntax.service;

import java.util.Map;

public interface StorageService {

    int getQuantity(String key);

    void updateQuantity(String name, Integer value);

    void add(String fruitName, Integer value);

    Map<String, Integer> getAll();
}
