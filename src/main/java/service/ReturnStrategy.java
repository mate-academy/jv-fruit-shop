package service;

import db.Storage;

public class ReturnStrategy implements ActivityStrategy {

    @Override
    public void doActivity(String fruitName, int quantity) {
        Storage.add(fruitName, Storage.get(fruitName) + quantity);
    }
}
