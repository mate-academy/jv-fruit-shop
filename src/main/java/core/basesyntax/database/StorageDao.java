package core.basesyntax.database;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface StorageDao {
    void add(Fruit fruit);

    Fruit get(String fruitName);

    boolean fruitIsInStorage(String fruitName);

    List<Fruit> getAll();
}
