package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.fruitmodel.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void save(Fruit fruit, Integer quantity) {
        FruitStorage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public Integer get(Fruit fruit) {
        return FruitStorage.fruitStorage.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return FruitStorage.fruitStorage;
    }
}
