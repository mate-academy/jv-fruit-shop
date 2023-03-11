package strategy;

import db.Storage;
import model.Fruit;
import model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int quantity = transactionDto.getQuantity();
        int oldQuantity = Storage.storage.get(fruit);
        if (oldQuantity < quantity) {
            throw new RuntimeException("We don't have that much fruit");
        }
        quantity = oldQuantity - quantity;
        Storage.storage.put(fruit, quantity);
    }
}
