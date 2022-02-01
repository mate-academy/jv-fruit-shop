package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void put(String fruitName, Integer friutQuantity);

    void summQuantity(String fruitName, Integer friutQuantity);

    void subtractQuantity(String fruitName, Integer friutQuantity);

    Map<String, Integer> getAll();
}
