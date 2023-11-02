package core.basesyntax.dao;

import java.util.Map;

import static core.basesyntax.db.FruitStorage.fruitStorage;  // static import

public class FruitStorageDaoImpl implements StorageDao {

    @Override
    public Map<String, Integer> getStorage() {
        return fruitStorage;
    }

    @Override
    public int getAmountByObjectType(String fruitName) {
        return fruitStorage.get(fruitName);
    }

    @Override
    public void putToStorage(String fruitName, int amount) {
        fruitStorage.put(fruitName, amount);
    }
}
