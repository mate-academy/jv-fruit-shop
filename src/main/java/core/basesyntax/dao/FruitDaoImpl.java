package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addFruit(Fruit fruit) {
        Storage.fruitsStorage.put(fruit, 0);
    }

    @Override
    public void addQuantity(Fruit fruit, int quantity) {
        int prevQuantity = getQuantity(fruit);
        Storage.fruitsStorage.put(fruit, prevQuantity + quantity);
    }

    @Override
    public void subtractQuantity(Fruit fruit, int quantity) {
        int prevQuantity = getQuantity(fruit);
        if (prevQuantity - quantity < 0) {
            throw new RuntimeException("Balance cant be negative");
        }
        Storage.fruitsStorage.put(fruit, prevQuantity - quantity);
    }

    @Override
    public Integer getQuantity(Fruit fruit) {
        return Storage.fruitsStorage.get(fruit);
    }

    @Override
    public Set<Fruit> getFruitsSet() {
        return Storage.fruitsStorage.keySet();
    }
}
