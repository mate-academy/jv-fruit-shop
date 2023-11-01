package core.basesyntax.handlers;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(String fruit,int quantity) {
        int quantityAfterReturn = Storage.fruits.get(fruit) + quantity;
        Storage.fruits.put(fruit, quantityAfterReturn);
    }
}
