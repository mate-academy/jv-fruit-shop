package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitsDao {
    boolean add(Fruit fruit);
    Fruit get(String someFruit);
}