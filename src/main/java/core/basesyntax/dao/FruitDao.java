package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {
    Integer getQuantity(String fruitName);

    void update(String fruitName, Integer amount);

    List<Fruit> getAll();
}
