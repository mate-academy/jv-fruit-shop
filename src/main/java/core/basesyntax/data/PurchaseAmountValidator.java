package core.basesyntax.data;

import core.basesyntax.exceptions.IncorrectPurchasedAmountException;

public class PurchaseAmountValidator implements DataValidator {
    @Override
    public boolean validate(int balance, int checkedAmount) {
        if (checkedAmount < 0) {
            throw new IncorrectPurchasedAmountException("Incorrect purchased amount: "
                    + checkedAmount);
        }
        if (balance < checkedAmount) {
            throw new IncorrectPurchasedAmountException("Purchased amount: "
                    + checkedAmount + ", greater then available balance: " + balance);
        }
        return true;
    }
}
