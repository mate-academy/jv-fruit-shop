package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    private final Map<Fruit, Integer> storage;

    public FruitDaoImpl(Map<Fruit, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void addNewFruit(Fruit fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    @Override
    public Integer getQuantityByFruit(Fruit fruit) {
        return storage.get(fruit);
    }

    @Override
    public void subtractQuantityByFruit(Fruit fruit, int quantityToSubtract) {
        if (quantityToSubtract <= storage.get(fruit)) {
            storage.replace(fruit,
                    storage.get(fruit) - quantityToSubtract);
        }
    }

    @Override
    public void addQuantityByFruit(Fruit fruit, int quantityToAdd) {
        storage.replace(fruit,
                storage.get(fruit) + quantityToAdd);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return storage;
    }
}
