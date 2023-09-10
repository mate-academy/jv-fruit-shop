package strategy.impl;

import db.Warehouse;
import strategy.Balance;

public class BalanceImpl implements Balance {
    @Override
    public void getBalance(String fruit, int quantity) {
        Warehouse.getStorage().put(Warehouse.TypeFruit.valueOf(fruit), quantity);
    }
}
