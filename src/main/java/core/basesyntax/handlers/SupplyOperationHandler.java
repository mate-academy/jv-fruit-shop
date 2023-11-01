package core.basesyntax.handlers;

import core.basesyntax.db.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(String fruit,int quantity) {
        int previousQuantity = Storage.fruits.get(fruit);
        int newQuantity = previousQuantity + quantity;
        Storage.fruits.put(fruit,newQuantity);
    }
}
