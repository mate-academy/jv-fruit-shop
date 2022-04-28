package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public void update(Fruit fruit) {
    }

    @Override
    public Fruit get(String fruitName) {
        try {
            return Storage.fruits.stream()
                    .filter(f -> f.getFruit().equals(fruitName))
                    .findFirst()
                    .get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public List<String> getStorage() {
        return Storage.fruits.stream()
                .map(f -> f.getFruit() + "," + f.getAmount())
                .collect(Collectors.toList());
    }

}
