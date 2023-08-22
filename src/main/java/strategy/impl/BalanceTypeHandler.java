package strategy.impl;

import strategy.ActivityTypeHandler;

public class BalanceTypeHandler implements ActivityTypeHandler {
    @Override
    public int getNewQuantity(int before, int after) {
        return after;
    }
}
