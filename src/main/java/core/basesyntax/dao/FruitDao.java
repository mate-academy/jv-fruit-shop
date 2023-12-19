package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void addFruit(String fruit, Integer quantity);

    Map<String, Integer> getBalance();
}
