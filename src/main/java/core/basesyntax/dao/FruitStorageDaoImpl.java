package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitStorageDaoImpl implements StorageDao {

    @Override
    public Map<String, Integer> getStorage() {
        return FruitStorage.getFruitStorage();
    }

    @Override
    public int getQuantityByObjectType(String fruit) {
        return FruitStorage.getFruitStorage().get(fruit);
    }

    @Override
    public void putToStorage(String fruit, int quantity) {
        FruitStorage.getFruitStorage().put(fruit, quantity);
    }
}
