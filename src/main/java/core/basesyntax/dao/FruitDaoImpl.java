package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Comparator;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    private final List<Fruit> fruits = Storage.getInstance().getStorage();

    @Override
    public void add(Fruit fruit) {
        fruits.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return fruits.stream()
                .filter(fruit -> fruit.getFruitName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDB = get(fruit.getFruitName());
        fruits.remove(fruitFromDB);
        add(fruit);
    }

    @Override
    public List<Fruit> getAll() {
        return fruits.stream()
                .sorted(Comparator.comparing(Fruit::getFruitName))
                .toList();
    }
}
