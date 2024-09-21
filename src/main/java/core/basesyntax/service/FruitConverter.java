package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitConverter {
    public static Fruit convertToFruit(String name) {
        for (Fruit fruit: Storage.keyset()) {
            if (fruit.getName().equals(name)) {
                return fruit;
            }
            break;
        }
        return new Fruit(name);
    }
}
