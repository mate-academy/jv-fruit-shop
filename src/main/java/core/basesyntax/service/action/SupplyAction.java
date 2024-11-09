package core.basesyntax.service.action;

import core.basesyntax.model.Apple;
import core.basesyntax.model.Banana;

public class SupplyAction implements ActionHandler {
    private Banana banana = new Banana();
    private Apple apple = new Apple();

    @Override
    public void countBanana(int amount) {
        int newBalance = banana.getBalance() + amount;
        banana.setBalance(newBalance);
    }

    @Override
    public void countApple(int amount) {
        int newBalance = apple.getBalance() + amount;
        apple.setBalance(newBalance);
    }
}
