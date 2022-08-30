package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.AmountService;

public class PurchaseAmountService implements AmountService {
    @Override
    public int getAmount(int amount) {
        if (amount > 0) {
            return amount * -1;
        }
        return amount;
    }
}
