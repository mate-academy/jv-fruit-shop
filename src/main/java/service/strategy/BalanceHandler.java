package service.strategy;

import db.Storage;
import model.Fruit;

public class BalanceHandler implements Handler {

    @Override
    public void calc(String fruit, int quantity) {
        Storage.storage.put(new Fruit(fruit), quantity);
    }
}
