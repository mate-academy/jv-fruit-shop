package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruitStorage.add(fruit);
    }

    @Override
    public void update(String name, long quantity) {
        Fruit fruit = getByName(name);
        fruit.setBalance(fruit.getBalance() + quantity);
    }

    @Override
    public long getBalance(String name) {
        return getByName(name).getBalance();
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruitStorage;
    }

    private Fruit getByName(String name) {
        return Storage.fruitStorage.stream()
                .filter(fruit -> fruit.getName().equals(name))
                .findFirst().get();
    }
}
