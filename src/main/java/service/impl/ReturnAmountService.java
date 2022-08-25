package service.impl;

import service.AmountService;

public class ReturnAmountService implements AmountService {
    @Override
    public int getAmount(int amount) {
        return amount;
    }
}
