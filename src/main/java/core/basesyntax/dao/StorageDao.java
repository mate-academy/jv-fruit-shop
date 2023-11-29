package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface StorageDao {
    void add(Fruit fruit);

    Fruit get(String fruitName);

    List<Fruit> getList();

    void update(Fruit fruit);

    int size();
}
