package dao;

import java.util.Map;

public interface AccountDao {
    int getAmountByFruit(String fruitName);

    void put(String fruitName, Integer quantity);

    Map<String, Integer> getAll();
}
