package core.basesyntax.dao.impl;

import core.basesyntax.dao.GoodsDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Accountable;
import core.basesyntax.model.Fruit;
import java.util.List;

public class FruitDaoImpl implements GoodsDao {
    @Override
    public void add(Accountable fruit) {
        Storage.getFruits().add(fruit);
    }

    @Override
    public Accountable get(String fruitName) {
        return Storage.getFruits().stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst().orElse(null);
    }

    @Override
    public Accountable create(String fruitName) {
        Accountable fruit = new Fruit(fruitName);
        add(fruit);
        return fruit;
    }

    @Override
    public boolean isExist(String fruitName) {
        return Storage.getFruits().stream()
                .anyMatch(f -> f.getName().equals(fruitName));
    }

    @Override
    public List<Accountable> getAll() {
        return Storage.getFruits();
    }
}
