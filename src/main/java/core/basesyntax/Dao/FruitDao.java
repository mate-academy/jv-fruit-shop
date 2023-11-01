package core.basesyntax.Dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface FruitDao {
    Map<String, Integer> getStorage();
    Integer get(String key);
    void add(String type, Integer quantity);
    void add(List<FruitTransaction> list);
}
