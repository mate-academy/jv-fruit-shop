package core.basesyntax.service.action;

import core.basesyntax.model.Account;

public class ReturnAction implements ActionHandler {
    private Account account;

    @Override
    public void countBanana(int amount) {
        int newBalance = account.getBananaBalance() + amount;
        account.setBananaBalance(newBalance);
    }

    @Override
    public void countApple(int amount) {
        int newBalance = account.getAppleBalance() + amount;
        account.setAppleBalance(newBalance);
    }
}
