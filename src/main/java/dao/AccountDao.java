package dao;

import java.util.Map;

public interface AccountDao {
    int getAmountByFruit(String fruitName);

    void putInfoToStorage(String fruitName, Integer quantity);

    Map<String, Integer> getAll();
}
