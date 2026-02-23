package service;

import db.Storage;

public class BalanceStrategy implements ActivityStrategy {

    @Override
    public void doActivity(String fruitName, int quantity) {
        Storage.add(fruitName, quantity);
    }
}
