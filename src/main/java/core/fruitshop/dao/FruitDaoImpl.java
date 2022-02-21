package core.fruitshop.dao;

import core.fruitshop.db.Storage;
import core.fruitshop.model.Fruit;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addFruit(Fruit fruit) {
        Storage.fruitsStorage.put(fruit, 0);
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
