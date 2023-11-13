package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void updateStock(String fruit, int amount);

    Map<String,Integer> getStock();
}
