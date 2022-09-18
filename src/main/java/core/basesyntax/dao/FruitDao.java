package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FruitDao {
    List<Fruit> get ();
    void add (FruitTransaction fruitTransaction);
}
