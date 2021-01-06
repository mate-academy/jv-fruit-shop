package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void add(Fruit fruit, int amount);

    Fruit getFruit(String fruitName);

    int getAmount(Fruit fruit);

    void update(Fruit fruit, int amount);

    Set<Map.Entry<Fruit, Integer>> getAllFruits();

    int getSize();

    boolean containsKey(Fruit fruit);
}
