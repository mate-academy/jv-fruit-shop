package dao;

import java.util.Map;

public interface FruitDao {
    Map<String, Integer> getAll();

    int getFruitQuantity(String fruitName);

    void setFruitQuantity(String fruitName, int quantity);
}
