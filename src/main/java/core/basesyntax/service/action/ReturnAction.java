package core.basesyntax.service.action;

import core.basesyntax.model.Fruit;

public class ReturnAction implements ActionHandler {

    @Override
    public void count(Fruit fruit, int amount) {
        int newBalance = fruit.getBalance() + amount;
        fruit.setBalance(newBalance);
    }
}
