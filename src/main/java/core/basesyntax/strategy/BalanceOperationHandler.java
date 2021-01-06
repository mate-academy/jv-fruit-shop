package core.basesyntax.strategy;

import core.basesyntax.exceptions.WrongFruitsAmountException;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer updateBalance(Integer balance, Integer value) {
        if (value < 0) {
            throw new WrongFruitsAmountException("Can't sell this amount of fruits");
        }
        return balance + value;
    }
}
