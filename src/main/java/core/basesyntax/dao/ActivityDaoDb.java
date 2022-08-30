package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface ActivityDaoDb {
    void put(Fruit fruit, int count);

    int getCount(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
