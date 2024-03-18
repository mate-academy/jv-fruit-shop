package core.basesyntax.dao;

import core.basesyntax.model.FruitItem;

import java.util.HashMap;

public interface StorageDao {
    HashMap<String, Integer> add(FruitItem fruit);
    HashMap<String, Integer> get(FruitItem fruit);
}
