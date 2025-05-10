package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {
    void add(Fruit fruit);

    Fruit getFruitByName(String fruitName);

    List<Fruit> getAll();

    void update(Fruit fruit);

    boolean isPresent(String fruitName);
}
