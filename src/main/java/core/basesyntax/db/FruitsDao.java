package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitsDao {
    void add(Fruit fruit);

    Fruit get(String someFruit);

    List<Fruit> getAll();
}
