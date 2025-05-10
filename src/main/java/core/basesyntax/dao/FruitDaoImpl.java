package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.errors.ErrorMessages;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public synchronized void add(Fruit fruit) {
        Storage.addFruit(fruit);
    }

    @Override
    public synchronized Fruit getFruitByName(String fruitName) {
        return Storage.getFruits().stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.FRUIT_NOT_FOUND
                        + fruitName));
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.getFruits();
    }

    @Override
    public synchronized void update(Fruit fruit) {
        if (isPresent(fruit.getName())) {
            Fruit fruitFromDb = getFruitByName(fruit.getName());
            Storage.removeFruit(fruitFromDb);
        }
        add(fruit);
    }

    @Override
    public synchronized boolean isPresent(String fruitName) {
        return Storage.getFruits().stream()
                .anyMatch(fruit -> fruit.getName().equals(fruitName));
    }
}
