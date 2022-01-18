package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitsData;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Optional<Integer> get(Fruit fruit) {
        if (FruitsData.fruitMap.containsKey(fruit)) {
            return Optional.of(FruitsData.fruitMap.get(fruit));
        }
        return Optional.empty();
    }

    @Override
    public void put(Fruit fruit, int amount) {
        FruitsData.fruitMap.put(fruit, amount);
    }
}
