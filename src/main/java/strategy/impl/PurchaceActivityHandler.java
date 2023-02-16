package strategy.impl;

import strategy.ActivityHandler;

public class PurchaceActivityHandler implements ActivityHandler {
    @Override
    public int count(int balance, int amount) {
        return balance - amount;
    }
}
