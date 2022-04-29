package dao;

import java.util.Map;
import java.util.Set;
import model.Fruit;

public interface StorageDao {
    void update(Fruit fruit, int quantity);

    Set<Map.Entry<Fruit, Integer>> addAll();

    Integer get(Fruit fruit);
}
