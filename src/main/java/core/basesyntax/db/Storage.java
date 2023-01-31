package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface Storage {
    void put(Fruit fruit);

    Fruit get(String fruitName);

    List<Fruit> getAll();
}
