package core.basesyntax.service.impl;

import core.basesyntax.service.AmountService;

public class BalanceAmountService implements AmountService {
    @Override
    public int getAmount(int amount) {
        return amount;
    }
}
