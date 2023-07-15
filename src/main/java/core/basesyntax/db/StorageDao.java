package core.basesyntax.db;

import java.util.Map;
import java.util.Set;

public interface StorageDao {

    void add(String fruitName, int quantity);

    Integer get(String fruitName);

    Set<Map.Entry<String,Integer>> getAll();
}
