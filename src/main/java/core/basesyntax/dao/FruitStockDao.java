package core.basesyntax.dao;

import java.util.Map;

public interface FruitStockDao {
    void add(Map.Entry<String,Integer> entry);

    Map.Entry<String,Integer> get(String fruit);

    void update(Map.Entry<String,Integer> entry);
}
