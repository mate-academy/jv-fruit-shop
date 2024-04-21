package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface FruitStorageDao {
    void addFruit(FruitTransaction fruitTransaction);

    void increaseQuantity(FruitTransaction fruitTransaction);

    void decreaseQuantity(FruitTransaction fruitTransaction);

    Map<String, Integer> getAllAsMap();
}
