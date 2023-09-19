package core.basesyntax.db;

import core.basesyntax.model.Fruit;

public interface StorageDao {
    boolean increaseFruitsAmount(Fruit fruit, int quantity);

    boolean decreaseFruitsAmount(Fruit fruit, int quantity);

    boolean addNewFruit(Fruit fruit, int quantity);
}
