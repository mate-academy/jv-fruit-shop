package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, int quantity) {
        Storage.fruitsStorage.put(fruit,quantity);
    }

    @Override
    public int getFruitQuantity(String fruitName) {
        return Storage.fruitsStorage.entrySet().stream()
                .filter(f -> f.getKey().getName().equals(fruitName))
                .map(f -> f.getValue())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such fruit in Storage " + fruitName));
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.fruitsStorage;
    }
}
