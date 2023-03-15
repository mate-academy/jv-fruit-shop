package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitStorage {
    void put(Fruit fruit);

    Fruit getByName(String name);

    List<Fruit> getAll();
}
