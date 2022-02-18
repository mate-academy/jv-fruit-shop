package core.basesyntax.dao;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        FruitsStorage.getFruits().add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return FruitsStorage.getFruits().stream()
                .filter(f -> f.getFruitType().equals(fruitName))
                .findFirst()
                .get();
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(FruitsStorage.getFruits());
    }
}
