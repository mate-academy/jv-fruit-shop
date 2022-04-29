package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruits.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<String> getAll() {
        return Storage.fruits.stream()
                .map(f -> f.getName() + "," + f.getAmount())
                .collect(Collectors.toList());
    }

    @Override
    public void addNew(String fruitName, int amount) {
        Fruit fruit = new Fruit();
        fruit.setName(fruitName);
        fruit.setAmount(amount);
        add(fruit);
    }
}
