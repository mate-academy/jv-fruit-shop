package strategy;

import db.Storage;
import model.Fruit;
import model.TransactionDto;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int quantity = transactionDto.getQuantity();
        if (transactionDto.getOperation().equals("b")) {
            Storage.storage.put(fruit, quantity);
            return;
        }
        int oldQuantity = Storage.storage.get(fruit);
        quantity += oldQuantity;
        Storage.storage.put(fruit, quantity);
    }
}
