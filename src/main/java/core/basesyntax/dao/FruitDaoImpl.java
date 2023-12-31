package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.math.BigDecimal;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Fruit get(Fruit fruit) {
        return Storage.fruitsStorage.stream()
                .filter(f -> f.getName()
                        .equals(fruit.getName()))
                .findFirst()
                .get();
    }

    @Override
    public void add(Fruit fruit) {
        Storage.fruitsStorage.add(fruit);
    }

    @Override
    public boolean update(Fruit fruit, BigDecimal value) {
        get(fruit).setQuantity(value);
        return false;
    }

    @Override
    public List<Fruit> getAll() {
        return Storage.fruitsStorage;
    }
}
