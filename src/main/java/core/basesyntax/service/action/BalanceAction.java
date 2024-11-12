package core.basesyntax.service.action;

import core.basesyntax.model.Fruit;

public class BalanceAction implements ActionHandler {

    @Override
    public void count(Fruit fruit, int amount) {
        fruit.setBalance(amount);
    }
}
