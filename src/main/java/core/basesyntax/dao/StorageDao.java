package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

import java.util.List;

public interface StorageDao {
    Integer getAmount(Fruit fruit);
    void update(Fruit fruit, Integer amount);
    List<Fruit> getAll();
}
