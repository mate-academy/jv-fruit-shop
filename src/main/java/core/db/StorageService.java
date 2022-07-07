package core.db;

import java.util.Map;

public interface StorageService<T> {
    Map<String, Integer> addFruit(T transaction);

    Map<String, Integer> getLeftovers();

    Integer getFruitQuantity(String fruit);

    void setFruitQuantity(String fruit, Integer quantity);
}
