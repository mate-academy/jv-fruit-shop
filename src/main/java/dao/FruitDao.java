package dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    Integer getFruitBalance(String fruit);

    boolean addBalanceOfFruit(String fruit, int quantity);

    void updateBalanceOfFruit(String fruit, int quantity);

    Set<Map.Entry<String, Integer>> getAllFruit();

}
