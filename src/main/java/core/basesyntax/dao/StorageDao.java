package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface StorageDao {
    void add(Fruit fruit);
    Fruit get(String fruitName);
}
