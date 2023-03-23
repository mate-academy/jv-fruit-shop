package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

import java.util.Map;

public interface StorageDao {
    Fruit add(Fruit fruit, int quantity);
    Integer getQuantity(Fruit fruit);
    int size();
}
