package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface StorageDao {
    void addFruit(Fruit fruit);

    Fruit getFruit(String fruitName);

    List<Fruit> getAll();
}
