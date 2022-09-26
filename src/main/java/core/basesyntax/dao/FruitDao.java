package core.basesyntax.dao;

import java.util.HashMap;

public interface FruitDao {
    int getAmount(String fruitName);

    void add(String fruitName, int quantity);

    void changeAmount(String fruitName, int newAmount);

    HashMap<String, Integer> getStorageData();
}
