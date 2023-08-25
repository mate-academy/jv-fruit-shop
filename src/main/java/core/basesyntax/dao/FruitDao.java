package core.basesyntax.dao;

import core.basesyntax.model.FruitItem;
import java.util.List;

public interface FruitDao {
    void put(FruitItem fruitItem);

    boolean containsName(String fruitName);

    FruitItem getByName(String fruitName);

    void removeByName(String fruitName);

    List<FruitItem> getAll();
}
