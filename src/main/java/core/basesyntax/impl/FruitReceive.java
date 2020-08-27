package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.Supplier;
import core.basesyntax.model.Fruit;

public class FruitReceive implements Supplier<Fruit> {
    @Override
    public void supplyFruit(Fruit fruit) {
        if (Storage.fruitStorage.peek() == null) {
            Storage.fruitStorage.add(fruit);
            return;
        }
        for (Fruit listedFruit : Storage.fruitStorage) {
            if (listedFruit.equals(fruit)) {
                listedFruit.amount += fruit.amount;
            } else {
                Storage.fruitStorage.add(fruit);
            }
        }
    }
}
