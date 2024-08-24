package dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    Integer getBalance(String fruit);

    boolean addBalance(String fruit, int quantity);

    void updateBalance(String fruit, int quantity);

    Set<Map.Entry<String, Integer>> getAllEntries();
}
