package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {

    @Override
    public boolean add(Fruit fruit, int quantity) {
        Storage.getFruitStorage().put(fruit, quantity);
        return true;
    }

    @Override
    public Fruit getFruit(String fruitName) {
        for (Fruit fruit : Storage.getFruitStorage().keySet()) {
            if (fruit.getName().equals(fruitName)) {
                return fruit;
            }
        }
        return null;
    }

    @Override
    public Integer getQuantity(String fruitName) {
        for (Fruit fruit : Storage.getFruitStorage().keySet()) {
            if (fruit.getName().equals(fruitName)) {
                return Storage.getFruitStorage().get(fruit);
            }
        }
        return null;
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.getFruitStorage();
    }
}
