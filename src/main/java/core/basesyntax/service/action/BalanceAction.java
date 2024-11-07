package core.basesyntax.service.action;

import core.basesyntax.model.Account;

public class BalanceAction implements ActionHandler {
    private Account account;

    @Override
    public void countBanana(int amount) {
        account.setBananaBalance(amount);
    }

    @Override
    public void countApple(int amount) {
        account.setAppleBalance(amount);
    }
}
