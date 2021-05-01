package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void clearStorage();

    Map<String, Integer> getAll();

    Integer getQuantity(String fruitName);

    boolean containFruit(String fruitName);
}
