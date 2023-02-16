package strategy.impl;

import strategy.ActivityHandler;

public class BalanceActivityHandler implements ActivityHandler {
    @Override
    public int count(int balance, int amount) {
        return amount;
    }
}
