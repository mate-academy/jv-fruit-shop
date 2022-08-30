package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.AmountService;

public class BalanceAmountService implements AmountService {
    @Override
    public int getAmount(int amount) {
        return amount;
    }
}
