package app.strategy.impl;

import app.db.Storage;
import app.dto.Transaction;
import app.model.Fruit;
import app.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int currentQuantity = Storage.storage.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity - transactionDto.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Fruit shop haven't this amount of : "
                    + transactionDto.getName() + "s");
        }
        Storage.storage.put(fruit, newQuantity);
        return newQuantity;
    }
}
