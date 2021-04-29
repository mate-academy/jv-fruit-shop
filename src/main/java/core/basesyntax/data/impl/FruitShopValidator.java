package core.basesyntax.data.impl;

import core.basesyntax.data.DataValidator;
import core.basesyntax.exceptions.IncorrectAmountException;

public class FruitShopValidator implements DataValidator {
    @Override
    public void validateAmount(int balance, int checkedAmount) {
        validateAmountPositive(checkedAmount);
        if (balance < checkedAmount) {
            throw new IncorrectAmountException("Purchased amount: "
                    + checkedAmount + ", greater then available balance: " + balance);
        }
    }

    @Override
    public void validateAmountPositive(Integer fruitAmount) {
        if (fruitAmount < 0) {
            throw new IncorrectAmountException("Amount couldn't be negative");
        }
    }
}
