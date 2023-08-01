package strategy.handler;

import db.Storage;

public class BalanceHandler implements Handler {
    @Override
    public void fruitOperation(String fruit, int quantity) {
        if (checkNegative(quantity)) {
            throw new RuntimeException("Quantity cannot be less than zero" + quantity);
        }
        if (checkNull(fruit)) {
            throw new RuntimeException("Fruit cannot be null");
        }
        Storage.storage.put(fruit, quantity);
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
