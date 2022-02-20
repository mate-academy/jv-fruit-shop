package service.strategy;

import db.Storage;
import model.Fruit;

public class ReturnHandler implements Handler {
    @Override
    public void calc(String fruit, int quantity) {
        Storage.storage.put(new Fruit(fruit), (Storage.storage.get(new Fruit(fruit)) + quantity));
    }
}
