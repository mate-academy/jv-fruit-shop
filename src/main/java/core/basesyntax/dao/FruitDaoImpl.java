package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.fruitmodel.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private FruitStorage fruitStorage = new FruitStorage();

    @Override
    public void save(Fruit fruit, Integer quantity) {
        fruitStorage.getFruitStorage().put(fruit, quantity);
    }

    @Override
    public Integer get(Fruit fruit) {
        return fruitStorage.getFruitStorage().get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return fruitStorage.getFruitStorage();
    }
}
