package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface ActivityDaoDb {
    void put(Fruit fruit, int count);

    int getCount(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
