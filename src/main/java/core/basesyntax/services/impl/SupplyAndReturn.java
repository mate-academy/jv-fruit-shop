package core.basesyntax.services.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.services.SupplyInterface;

public class SupplyAndReturn implements SupplyInterface {
    @Override
    public void action(Storage storage, Fruit fruit) {
        if (storage.getFruits().contains(fruit)) {
            int storagePositionFruit = storage.getFruits().indexOf(fruit);
            int newCount = storage.getFruits().get(storagePositionFruit).getStock_balance() + fruit.getStock_balance();
            storage.getFruits().get(storagePositionFruit).setStock_balance(newCount);
        } else {
            storage.getFruits().add(fruit);
        }
    }
}
