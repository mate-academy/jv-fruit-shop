package dao;

import java.util.Map;
import java.util.Set;
import model.Fruit;

public interface StorageDao {
    void update(Fruit fruit, int quantity);

    Set<Map.Entry<Fruit, Integer>> getAll();

    Integer get(Fruit fruit);
}
