package core.basesyntax.db.dao;

import core.basesyntax.model.Fruits;

public interface FruitDao {
    void create(Fruits fruits);
    Fruits read(Fruits fruits);
    void update(Fruits fruits);
    void delete(Fruits fruits);
}
