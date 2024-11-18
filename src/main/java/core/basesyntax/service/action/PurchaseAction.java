package core.basesyntax.service.action;

import static core.basesyntax.model.Storage.storageOfFruits;

import core.basesyntax.model.Fruit;

public class PurchaseAction implements ActionHandler {
    @Override
    public void count(Fruit fruit, int amount) {
        int newBalance = storageOfFruits.get(fruit) - amount;
        storageOfFruits.put(fruit, newBalance);
    }
}
