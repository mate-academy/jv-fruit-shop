package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Fruit getFruit(Fruit fruit) {
        Map.Entry<Fruit, Integer> entry = findEntry(fruit);
        return entry != null ? entry.getKey() : addNewFruit(fruit);
    }

    @Override
    public Integer getQuantityFromFruit(Fruit fruit) {
        Map.Entry<Fruit, Integer> entry = findEntry(fruit);
        if (entry != null) {
            return entry.getValue();
        }
        throw new RuntimeException(fruit + " does not exist");
    }

    @Override
    public void updateQuantity(Fruit fruit, Integer quantity) {
        if (!Storage.getFruits().containsKey(fruit)) {
            addNewFruit(fruit);
        }
        Map.Entry<Fruit, Integer> entry = findEntry(fruit);
        if (entry != null) {
            entry.setValue(quantity);
        }
    }

    private Map.Entry<Fruit, Integer> findEntry(Fruit fruit) {
        for (Map.Entry<Fruit, Integer> entry : Storage.getFruits().entrySet()) {
            if (entry.getKey().equals(fruit)) {
                return entry;
            }
        }
        return null;
    }

    private Fruit addNewFruit(Fruit fruit) {
        Storage.getFruits().put(fruit, 0);
        return fruit;
    }
}
