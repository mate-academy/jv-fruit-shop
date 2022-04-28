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
    public void saveToStorage(Fruit element) {
        Storage.fruits.put(element.getName(), element.getQuantity());
    }

    @Override
    public Optional<Fruit> get(Fruit key) {
        return Storage.fruits.entrySet().stream()
                .filter(k -> key.getName().equals(k.getKey()))
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
    public Fruit update(Fruit element) {
        Storage.fruits.entrySet().stream()
                .filter(f -> f.getKey().equals(element.getName()))
                .findFirst()
                .map(f -> f.setValue(f.getValue() + element.getQuantity()));
        return element;
    }

    @Override
    public boolean delete(Fruit element) {
        return Storage.fruits.keySet().removeIf(f -> f.equals(element.getName()));
    }
}
