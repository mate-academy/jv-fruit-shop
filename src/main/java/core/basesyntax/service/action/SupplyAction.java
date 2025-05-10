package core.basesyntax.service.action;

import static core.basesyntax.storage.Storage.storageOfFruits;

public class SupplyAction implements ActionHandler {
    @Override
    public void count(String fruit, int amount) {
        checkAmount(amount);

        int newBalance = storageOfFruits.get(fruit) + amount;
        storageOfFruits.put(fruit, newBalance);
    }
}
