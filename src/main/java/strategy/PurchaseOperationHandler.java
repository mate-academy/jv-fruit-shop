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
        int newQuality;
        try {
            newQuality = oldQuantity - quantity;
        } catch (RuntimeException e) {
            throw new RuntimeException("Negative value", e);
        }
        Storage.storage.put(fruit, newQuality);
    }
}
