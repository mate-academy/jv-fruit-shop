package dao;

import java.util.Map;
import java.util.Set;
import model.Fruit;

public interface StorageDao {
    void add(Fruit fruit, int quantity);

    Integer get(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getSet();
}
