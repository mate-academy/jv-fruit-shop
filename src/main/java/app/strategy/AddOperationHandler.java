package app.strategy;

import app.db.Storage;
import app.dto.Transaction;
import app.model.Fruit;

public class AddOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int currentQuantity = Storage.storage.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity + transactionDto.getQuantity();
        Storage.storage.put(fruit, newQuantity);
        return newQuantity;
    }
}
