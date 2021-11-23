package core.basesyntax.db.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    void create(Fruit fruits, int quantity);

    Integer read(Fruit fruit);

    void update(Fruit fruits, int quantity);
}
