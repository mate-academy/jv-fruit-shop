package strategy.impl;

import strategy.ActivityHandler;

public class SupplyActivityHandler implements ActivityHandler {
    @Override
    public int count(int balance, int amount) {
        return balance + amount;
    }
}
