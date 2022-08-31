package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import java.util.Map;
import java.util.Set;

public class ActivityDaoDbImpl implements ActivityDaoDb {
    @Override
    public void put(Fruit fruit, int count) {
        Storage.data.put(fruit, count);
    }

    @Override
    public int getCount(Fruit fruit) {
        Integer value = Storage.data.get(fruit);
        return value == null ? 0 : value;
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.data.entrySet();
    }
}
