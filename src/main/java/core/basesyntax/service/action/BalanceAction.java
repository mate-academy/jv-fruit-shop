package core.basesyntax.service.action;

import static core.basesyntax.model.Storage.storageOfFruits;

public class BalanceAction implements ActionHandler {
    @Override
    public void count(String fruit, int amount) {
        storageOfFruits.put(fruit, amount);
    }
}
