package core.basesyntax.db;

import core.basesyntax.model.Fruit;

public interface StorageDao {

    void add(Fruit fruit);

    Fruit get(String name);

    Fruit[] getAll();
}
