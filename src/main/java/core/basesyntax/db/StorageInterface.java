package core.basesyntax.db;

import java.util.Map;

public interface StorageInterface {

    Map<String, Integer> getAll();

    void put(String fruitName, int quantity);

    int getQuantity(String fruitName);
}
