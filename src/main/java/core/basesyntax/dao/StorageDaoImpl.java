package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void update(Fruit fruit, int quantity) {
        Storage.dataBase.compute(fruit, (key, val) -> val == null ? quantity : val + quantity);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.dataBase.entrySet();
    }

    @Override
    public Integer get(Fruit fruit) {
        if (fruit == null) {
            throw new RuntimeException("Fruit with such name: "
                    + fruit.getFruit() + " doesn't exist");
        }
        return Storage.dataBase.get(fruit);
    }
}
