package strategy;

import db.Storage;
import model.Fruit;
import model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int quantity = transactionDto.getQuantity();
        int currentQuantity = Storage.storage.getOrDefault(fruit, 0);
        if (currentQuantity - quantity < 0) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        currentQuantity -= quantity;
        Storage.storage.put(fruit, currentQuantity);
    }
}
