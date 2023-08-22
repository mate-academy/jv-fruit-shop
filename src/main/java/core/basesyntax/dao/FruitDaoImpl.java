package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.getFruits().add(fruit);
    }

    @Override
    public Fruit get(String name) {
        return Storage.getFruits().stream()
                .filter(fruit -> fruit.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't get product with name: " + name));
    }

    public boolean containsFruitWithName(String name) {
        return Storage.getFruits().stream()
                .anyMatch(fruit -> fruit.getName().equals(name));
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDb = get(fruit.getName());
        Storage.getFruits().remove(fruitFromDb);
        add(fruit);
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.getFruits();
    }
}
