package db;

import java.util.Map;

public interface ShopStorage {
    void updateQuantity(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getFruitQuantities();
}
