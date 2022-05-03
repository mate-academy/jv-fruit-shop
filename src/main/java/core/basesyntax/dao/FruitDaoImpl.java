package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addFruit(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit getByName(String fruitName) {
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
    public void addAmount(Fruit fruit) {
        Storage.fruits.stream()
                .filter(f -> f.getName().equals(fruit.getName()))
                .findFirst()
                .get()
                .setAmount(getByName(fruit.getName()).getAmount() + fruit.getAmount());
    }

    @Override
    public void subtractAmount(Fruit fruit) {
        Storage.fruits.stream()
                .filter(f -> f.getName().equals(fruit.getName()))
                .findFirst()
                .get()
                .setAmount(getByName(fruit.getName()).getAmount() - fruit.getAmount());
    }
}
