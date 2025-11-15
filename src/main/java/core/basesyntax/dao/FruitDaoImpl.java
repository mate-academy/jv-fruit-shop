package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(String fruitName, int quantity,
                    BiFunction<Integer, Integer, Integer> operation) {
        Map<String, Integer> storage = FruitStorage.getStorage();

        int current = storage.getOrDefault(fruitName, 0);
        int result = operation.apply(current, quantity);

        if (result < 0) {
            throw new RuntimeException("Not enough " + fruitName + " in storage!");
        }

        FruitStorage.updateStorage(fruitName, result);
    }

    @Override
    public Integer get(String fruitName) {
        Map<String, Integer> storage = FruitStorage.getStorage();
        Integer value = storage.get(fruitName);

        if (value != null) {
            return value;
        } else {
            throw new NoSuchElementException("No such element: " + fruitName);
        }

    }

    @Override
    public Map<String, Integer> getAll() {
        return FruitStorage.getStorage();
    }
}
