package core.basesyntax.service.action;

import static core.basesyntax.model.Storage.storageOfFruits;

public class PurchaseAction implements ActionHandler {
    @Override
    public void count(String fruit, int amount) {
        int newBalance = storageOfFruits.get(fruit) - amount;
        storageOfFruits.put(fruit, newBalance);
    }
}
