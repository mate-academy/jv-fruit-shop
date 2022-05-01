package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit, int quantity) {
        FruitStorage.fruits.put(fruit, quantity);
    }

    @Override
    public void update(Fruit fruit, int quantity) {
        if (FruitStorage.fruits.containsKey(fruit)) {
            FruitStorage.fruits.replace(fruit, quantity);
        } else {
            add(fruit, quantity);
        }
    }

    @Override
    public Integer getAmount(Fruit fruit) {
        if (!FruitStorage.fruits.containsKey(fruit)) {
            throw new RuntimeException("There are no such fruit in storage");
        }
        return FruitStorage.fruits.get(fruit);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return FruitStorage.fruits.entrySet();
    }
}
