package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit, int amount) {
        Storage.fruits.put(fruit, amount);
    }

    @Override
    public Fruit getFruit(String fruitName) {
        return Storage.fruits.keySet().stream()
                .filter(integer -> integer.getFruitName().equals(fruitName))
                .findFirst()
                .get();
    }

    @Override
    public int getAmount(Fruit fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public void update(Fruit fruit, int amount) {
        if (Storage.fruits.get(fruit) + amount < 0) {
            throw new ArithmeticException("Amount cannot be below than zero");
        }
        Storage.fruits.replace(fruit, Storage.fruits.get(fruit) + amount);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAllFruits() {
        return Storage.fruits.entrySet();
    }

    @Override
    public int getSize() {
        return Storage.fruits.size();
    }

    public boolean containsKey(Fruit fruit) {
        return Storage.fruits.containsKey(fruit);
    }
}
