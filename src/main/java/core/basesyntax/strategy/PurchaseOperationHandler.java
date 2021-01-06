package core.basesyntax.strategy;

import core.basesyntax.exceptions.WrongFruitsAmountException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer updateBalance(Integer balance, Integer value) {
        if (value > balance) {
            throw new WrongFruitsAmountException("Can't purchase this amount of fruits");
        }
        if (value < 0) {
            throw new WrongFruitsAmountException("Can't purchase this amount of fruits");
        }
        return balance - value;
    }
}
