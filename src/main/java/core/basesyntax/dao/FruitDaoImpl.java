package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Integer getQuantity(String fruitName) {
        if (Storage.fruits.containsKey(fruitName)) {
            return Storage.fruits.get(fruitName);
        }
        throw new RuntimeException("There's no such a fruit in a Storage: " + fruitName);
    }

    @Override
    public void update(String fruitName, Integer amount) {
        Storage.fruits.put(fruitName, amount);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits.entrySet().stream()
                .map(i -> new Fruit(i.getKey(), i.getValue()))
                .collect(Collectors.toList());
    }
}
