package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(FruitTransaction fruit) {
        if (fruit == null) {
            throw new RuntimeException("Can't add information to storage, information is empty: "
                    + fruit);
        }
        Storage.getDataStorage().put(fruit.getFruit(), fruit.getQuantity());
    }

    @Override
    public Integer getValue(String fruit) {
        if (Storage.getDataStorage().isEmpty()) {
            throw new RuntimeException("Storage is empty");
        }
        return Storage.getDataStorage().get(fruit);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.getDataStorage();
    }
}
