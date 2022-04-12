package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StorageDao {
    void set(Fruit fruit, Integer amount);

    void add(Fruit fruit, Integer amount);

    void reduce(Fruit fruit, Integer amount);

    Integer get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
