package service.impl;

import service.AmountService;

public class BalanceAmountService implements AmountService {
    @Override
    public int getAmount(int amount) {
        return amount;
    }
}
