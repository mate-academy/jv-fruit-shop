package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

import java.io.File;
import java.util.List;

public interface FruitDao {
    List<Fruit> get ();
    void add (String availableList);
}
