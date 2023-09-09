package core.basesyntax.dao;

import core.basesyntax.model.FruitInStorage;
import java.util.Collection;

public interface FruitDao {
    void add(FruitInStorage product);

    FruitInStorage getByName(String name);

    void update(FruitInStorage product, int amount);

    Collection<FruitInStorage> getAll();
}
