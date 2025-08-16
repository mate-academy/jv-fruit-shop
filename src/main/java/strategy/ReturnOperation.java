package strategy;

import db.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity) {
        int currentQuantity = Storage.get(fruit);
        Storage.set(fruit, currentQuantity + quantity);
    }
}
