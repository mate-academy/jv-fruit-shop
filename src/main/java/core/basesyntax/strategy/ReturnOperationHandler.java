package core.basesyntax.strategy;

import core.basesyntax.exceptions.WrongFruitsAmountException;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer updateBalance(Integer balance, Integer value) {
        if (value < 0) {
            throw new WrongFruitsAmountException("Can't return this amount of fruits");
        }
        return balance + value;
    }
}
