package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruitStore.add(fruit);
    }

    @Override
    public Optional<Fruit> get(String fruitType) {
        return Storage.fruitStore.stream()
                .filter(i -> i.getType().equals(fruitType))
                .findFirst();
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruitStore;
    }
}
