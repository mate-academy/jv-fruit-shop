package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Set;

public interface FruitDao {
    void addFruit(Fruit fruit);

    Fruit findByFruitName(String fruitName);

    Set<Fruit> getAllFruits();
}
