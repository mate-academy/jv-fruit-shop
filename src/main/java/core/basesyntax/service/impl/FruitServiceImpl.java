package core.basesyntax.service.impl;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.TransactionService;

public class FruitServiceImpl implements FruitService {
    @Override
    public int calculate(TransactionService transactionStrategy, int count, int quantity) {
        return transactionStrategy.executeTransaction(count, quantity);
    }
}
