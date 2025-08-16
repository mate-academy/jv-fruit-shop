package strategy;

import db.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity) {
        Storage.set(fruit, quantity);
    }
}
