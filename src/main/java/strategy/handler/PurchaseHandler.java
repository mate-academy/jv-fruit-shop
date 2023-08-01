package strategy.handler;

import db.Storage;

public class PurchaseHandler implements Handler {
    @Override
    public void fruitOperation(String fruit, int quantity) {
        if (checkNegative(quantity)) {
            throw new RuntimeException("Quantity cannot be less than zero" + quantity);
        }
        if (checkNull(fruit)) {
            throw new RuntimeException("Fruit cannot be null");
        }
        if (Storage.storage.get(fruit) >= quantity) {
            Storage.storage.put(fruit, Storage.storage.get(fruit) - quantity);
        } else {
            throw new RuntimeException("You cannot sell more fruit than is available");
        }
    }

    @Override
    public boolean checkNull(String fruit) {
        return fruit == null;
    }

    @Override
    public boolean checkNegative(int quantity) {
        return quantity < 0;
    }
}
