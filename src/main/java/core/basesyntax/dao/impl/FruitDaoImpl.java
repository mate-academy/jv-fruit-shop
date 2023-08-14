package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        FruitStorage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return FruitStorage.fruits.stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst().orElse(null);
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDb = get(fruit.getName());
        FruitStorage.fruits.remove(fruitFromDb);
        add(fruit);
    }

    @Override
    public List<Fruit> getAll() {
        return FruitStorage.fruits;
    }
}
