package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {
    void add(Fruit fruit);
    Fruit get(String fruitName);
    List<String> getAll();
    void addNew(String fruitName, int amount);
}
