package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

import java.util.List;
import java.util.Set;

public interface StorageDao {
    Integer getAmount(Fruit fruit);
    void update(Fruit fruit, Integer amount);
    Set<Fruit> getAll();
}
