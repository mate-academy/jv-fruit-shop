package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitsDao {
    void add(Fruit fruit);

    Fruit getFruit(String fruit);

    List<Fruit> getAll();
}
