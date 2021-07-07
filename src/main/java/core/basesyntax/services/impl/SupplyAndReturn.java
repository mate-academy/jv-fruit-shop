package core.basesyntax.services.impl;

import core.basesyntax.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.services.ActionInterface;

public class SupplyAndReturn implements ActionInterface {
    private Storage storage;

    public SupplyAndReturn(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void action(Fruit fruit) {
        if (this.storage.getFruits().contains(fruit)) {
            int storagePositionFruit = storage.getFruits().indexOf(fruit);
            int newCount = storage.getFruits().get(storagePositionFruit).getStockBalance()
                            + fruit.getStockBalance();
            storage.getFruits().get(storagePositionFruit).setStock_balance(newCount);
        } else {
            storage.getFruits().add(fruit);
        }
    }
}
