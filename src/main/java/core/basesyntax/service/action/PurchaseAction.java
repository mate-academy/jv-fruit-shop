package core.basesyntax.service.action;

import static core.basesyntax.model.Storage.storageOfFruits;

public class PurchaseAction implements ActionHandler {
    @Override
    public void count(String fruit, int amount) {
        if (amount < 0) {
            throw new RuntimeException("You can not add negative amount of fruit"
                    + ", please change your report");
        }

        int newBalance = storageOfFruits.get(fruit) - amount;
        storageOfFruits.put(fruit, newBalance);
    }
}
