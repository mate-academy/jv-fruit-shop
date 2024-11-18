package core.basesyntax.service.action;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Storage;

public class BalanceAction implements ActionHandler {
    private Storage storage = new Storage();

    @Override
    public void count(Fruit fruit, int amount) {
        storage.getStorageOfFruits().put(fruit, amount);
    }
}
