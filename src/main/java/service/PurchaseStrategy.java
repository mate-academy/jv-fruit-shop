package service;

import db.Storage;

public class PurchaseStrategy implements ActivityStrategy {

    @Override
    public void doActivity(String fruitName, int quantity) {
        Storage.add(fruitName, Storage.get(fruitName) - quantity);
    }
}
