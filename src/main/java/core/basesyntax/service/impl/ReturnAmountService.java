package core.basesyntax.service.impl;

import core.basesyntax.service.AmountService;

public class ReturnAmountService implements AmountService {
    @Override
    public int getAmount(int amount) {
        return amount;
    }
}
