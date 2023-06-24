package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.getFruits().add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.getFruits()
                .stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Can't get value of fruit " + fruitName));
    }

    @Override
    public List<Fruit> getAll() {
        return new ArrayList<>(Storage.getFruits());
    }
}
