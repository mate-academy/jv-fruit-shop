package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    void addNewFruit(Fruit fruit, int quantityToAdd);

    Integer getQuantityByFruit(Fruit fruit);

    void subtractQuantityByFruit(Fruit fruit, int quantityToSubtract);

    void addQuantityByFruit(Fruit fruit, int quantityToAdd);

    Map<Fruit, Integer> getAll();
}
