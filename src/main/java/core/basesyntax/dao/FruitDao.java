package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Set;

public interface FruitDao {
    void addFruit(Fruit fruit);

    void addQuantity(Fruit fruit, int quantity);

    void subtractQuantity(Fruit fruit, int quantity);

    Integer getQuantity(Fruit fruit);

    Set<Fruit> getFruitsSet();
}
