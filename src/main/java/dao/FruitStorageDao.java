package dao;

import java.util.Map;

public interface FruitStorageDao {
    public void updateFruitQuantity(String fruit, int quantity);

    public int getFruitQuantity(String fruit);

    public Map<String, Integer> getAllFruit();
}
