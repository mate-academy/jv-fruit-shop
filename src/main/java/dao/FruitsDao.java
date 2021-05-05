package dao;

import java.util.Map;
import java.util.Set;
import model.Fruit;

public interface FruitsDao {
    void add(Fruit fruit, Integer amount);

    Integer getAmount(Fruit fruit);

    Fruit getAmountByType(String type);

    void update(Fruit fruit, Integer amount);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
