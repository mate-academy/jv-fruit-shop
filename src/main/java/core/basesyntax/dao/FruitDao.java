package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void update(String fruitName, int amount);

    void add(String fruitName, int amount);

    void remove(String fruitName, int amount);

    Map<String, Integer> getFruit(String fruitName);

    Map<String, Integer> getBalanceInStock();
}
