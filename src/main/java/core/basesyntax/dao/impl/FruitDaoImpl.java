package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitsData;
import core.basesyntax.model.Fruit;

import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Optional<Fruit> get(String name) {
        if (FruitsData.fruitMap.containsKey(name)) {
            return Optional.of(new Fruit(name, FruitsData.fruitMap.get(name)));
        }
        return Optional.empty();
    }

    @Override
    public void put(Fruit fruit) {
        FruitsData.fruitMap.put(fruit.getName(), fruit.getAmount());
    }
}
