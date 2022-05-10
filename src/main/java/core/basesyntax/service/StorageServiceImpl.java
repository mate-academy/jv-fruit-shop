package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class StorageServiceImpl implements StorageService {

    @Override
    public void add(Fruit fruit, int amount) {
        Map<Fruit, Integer> fruits = Storage.getFruits();
        if (fruits.keySet().contains(fruit)) {
            fruits.replace(new Fruit(fruit.getName()),
                    fruits.get(fruit), amount + fruits.get(fruit));
        } else {
            Storage.setFruits(fruit, amount);
        }
    }

    @Override
    public void get(Fruit fruit, int amount) {
        Map<Fruit, Integer> fruits = Storage.getFruits();
        if (!fruits.keySet().contains(fruit)) {
            throw new RuntimeException("There is no such fruit in the store");
        }
        if (fruits.get(fruit) < amount) {
            throw new RuntimeException("There is no such amount in the store. The remnant is "
                    + fruits.get(fruit));
        } else {
            fruits.get(fruit);
            updateStorage(fruit, amount);
        }

    }

    @Override
    public void updateStorage(Fruit fruit, int amount) {
        int remnant = Storage.getFruits().get(fruit) - amount;
        Storage.setFruits(new Fruit(fruit.getName()), remnant);
    }
}
