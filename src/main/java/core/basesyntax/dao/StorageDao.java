package core.basesyntax.dao;

import java.util.HashMap;

public interface StorageDao {
    HashMap<String, Integer> add(String fruitName, Integer quantity);

    Integer get(String fruitName);
}
