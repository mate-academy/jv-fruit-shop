package core.basesyntax.service.action;

import core.basesyntax.model.Apple;
import core.basesyntax.model.Banana;

public class BalanceAction implements ActionHandler {
    private Banana banana = new Banana();
    private Apple apple = new Apple();

    @Override
    public void countBanana(int amount) {
        banana.setBalance(amount);
    }

    @Override
    public void countApple(int amount) {
        apple.setBalance(amount);
    }
}
