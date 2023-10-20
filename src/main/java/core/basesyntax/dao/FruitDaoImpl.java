package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exception.InvalidFruitException;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Fruit get(String name) {
        return FruitStorage.fruits.stream()
                .filter(fruit -> fruit.getName().equals(name))
                .findFirst()
                .get();
    }

    @Override
    public void add(Fruit fruit) {
        if (fruit == null) {
            throw new InvalidFruitException("Fruit can't be null");
        }
        FruitStorage.fruits.add(fruit);
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDB = get(fruit.getName());
        FruitStorage.fruits.remove(fruitFromDB);
        add(fruit);
    }

    @Override
    public List<Fruit> getAll() {
        return FruitStorage.fruits;
    }
}
