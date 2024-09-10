package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Set;

public interface FruitStorageDao {
    boolean setBalance(Fruit fruit, int quantity);

    boolean add(Fruit fruit, int quantity);

    boolean subtract(Fruit fruit, int quantity);

    int getBalance(Fruit fruit);

    Set<Fruit> getAllFruits();
}
