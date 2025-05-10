package core.basesyntax.service.action;

import static core.basesyntax.storage.Storage.storageOfFruits;

public class BalanceAction implements ActionHandler {
    @Override
    public void count(String fruit, int amount) {
        checkAmount(amount);
        storageOfFruits.put(fruit, amount);
    }
}
