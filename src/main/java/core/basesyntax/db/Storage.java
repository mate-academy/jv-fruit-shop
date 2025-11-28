package core.basesyntax.db;

import java.util.Map;

public interface Storage {
    int get(String fruitName);

    void put(String fruitName, int quantity);

    Map<String, Integer> getFruitStore();
}
