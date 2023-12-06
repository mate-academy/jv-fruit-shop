package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void add(String fruitName, int count);

    Map<String, Integer> get();

}
