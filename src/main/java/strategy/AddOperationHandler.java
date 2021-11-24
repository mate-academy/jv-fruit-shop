package strategy;

import db.Storage;
import model.Fruit;
import model.TransactionDto;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int quantity = transactionDto.getQuantity();
        int oldQuantity = Storage.storage.getOrDefault(fruit, 0);
        quantity += oldQuantity;
        Storage.storage.put(fruit, quantity);
    }
}
