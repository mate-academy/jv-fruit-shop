package core.basesyntax.service.action;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Storage;

public class ReturnAction implements ActionHandler {
    private Storage storage = new Storage();

    @Override
    public void count(Fruit fruit, int amount) {
        int newBalance = storage.getStorageOfFruits().get(fruit) + amount;
        storage.getStorageOfFruits().put(fruit, newBalance);
    }
}
