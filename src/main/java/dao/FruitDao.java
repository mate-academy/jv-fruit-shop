package dao;

import java.util.Map;

public interface FruitDao {
    boolean containsFruit(String fruit);

    int getQuantity(String fruit);

    void update(String fruit, int quantity);

    Map<String, Integer> getAll();
}
