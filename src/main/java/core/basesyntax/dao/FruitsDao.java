package core.basesyntax.dao;

import java.util.Map;

public interface FruitsDao {
    void balance(String fruit, int quantity);

    void supply(String fruit, int quantity);

    void purchase(String fruit, int quantity);

    void returnFruits(String fruit, int quantity);

    Map<String, Integer> getInventory();
}
