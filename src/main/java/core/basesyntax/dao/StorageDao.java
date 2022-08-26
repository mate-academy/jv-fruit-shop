package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface StorageDao {
    Integer getAmount(String fruitName);

    void update(String fruitName, Integer amount);

    List<Fruit> getAll();
}
