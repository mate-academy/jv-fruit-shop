package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Fruit create(String name, int quantity) {
        return new Fruit(name, quantity);
    }

    @Override
    public void save(Fruit element) {
        Storage.fruits.put(element.getName(), element.getQuantity());
    }

    @Override
    public Optional<Fruit> get(String fruitName) {
        return Storage.fruits.entrySet().stream()
                .filter(k -> fruitName.equals(k.getKey()))
                .findFirst()
                .map(el -> new Fruit(el.getKey(), el.getValue()));
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruits.entrySet().stream()
                .map(k -> new Fruit(k.getKey(), k.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Fruit update(Fruit fruit) {
        Storage.fruits.entrySet().stream()
                .filter(f -> f.getKey().equals(fruit.getName()))
                .findFirst()
                .map(f -> f.setValue(f.getValue() + fruit.getQuantity()));
        return fruit;
    }

    @Override
    public boolean delete(Fruit element) {
        return Storage.fruits.keySet().removeIf(f -> f.equals(element.getName()));
    }
}
