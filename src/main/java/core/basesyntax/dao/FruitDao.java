package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {

    void updateQuantity(String fruitName, Integer quantity);

    Map<String, Integer> getFruitMap();
}
