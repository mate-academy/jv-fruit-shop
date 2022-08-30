package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.AmountService;

public class SupplyAmountService implements AmountService {
    @Override
    public int getAmount(int amount) {
        return amount;
    }
}
