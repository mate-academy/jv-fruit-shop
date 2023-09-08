package db;

import java.util.Set;

public interface Storage {
    int DEFAULT_QUANTITY = 0;

    void addFruitInQuantity(String fruitName, Integer quantity);

    void removeFruitInQuantity(String fruitName, Integer quantity);

    int getQuantity(String fruitName);

    Set<String> getAllItems();
}
