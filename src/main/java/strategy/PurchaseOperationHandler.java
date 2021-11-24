package strategy;

import db.Storage;
import model.Fruit;
import model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int oldQuantity = Storage.storage.get(fruit) == null ? 0 : Storage.storage.get(fruit);
        int quantity = transactionDto.getQuantity();
        quantity -= oldQuantity;
        Storage.storage.put(fruit, quantity);
    }
}
