package core.basesyntax.service.action;

import static core.basesyntax.model.Storage.storageOfFruits;

import core.basesyntax.model.Fruit;

public class BalanceAction implements ActionHandler {
    @Override
    public void count(Fruit fruit, int amount) {
        storageOfFruits.put(fruit, amount);
    }
}
