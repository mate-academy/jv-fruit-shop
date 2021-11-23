package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitStorageDao {
    boolean add(Fruit fruit, int quantity);

    Fruit getFruit(String fruitName);

    Integer getQuantity(String fruitName);

    Map<Fruit, Integer> getAll();
}
