package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

import java.util.List;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Fruit create(Fruit element) {
        Storage.fruits.put(element.getName(), element.getQuantity());
        return element;
    }

    @Override
    public Optional<Fruit> get(Fruit key) {
        return Optional.empty();
    }

    @Override
    public List<Fruit> getAll() {
        return null;
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
    public boolean delete(Fruit key) {
//        return Storage.fruits.keySet().removeIf(String::isBlank);
        return Storage.fruits.keySet().removeIf(f -> f.equals(key.getName()));
    }
}
