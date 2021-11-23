package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public void addNewFruitToStorage(Fruit fruit) {
        Storage.fruitStorage.putIfAbsent(fruit.getName(), fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruitStorage.get(fruitName);
    }

    @Override
    public void update(Fruit fruit, int quantity) {
        int set = fruit.getQuantity() + quantity;
        fruit.setQuantity(set);
        Storage.fruitStorage.put(fruit.getName(), fruit);
    }
}
