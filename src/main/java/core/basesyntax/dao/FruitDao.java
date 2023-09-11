package core.basesyntax.dao;

import core.basesyntax.model.FruitInStorage;
import java.util.List;

public interface FruitDao {
    void add(FruitInStorage product);

    FruitInStorage getByName(String name);

    void update(FruitInStorage product, int amount);

    List<FruitInStorage> getAll();
}
