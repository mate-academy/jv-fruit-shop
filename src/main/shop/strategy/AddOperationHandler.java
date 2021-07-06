package strategy;

import db.Storage;
import dto.Transaction;
import model.Fruit;

public class AddOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int currentQuantity = Storage.storage.getOrDefault(fruit, 0);
        int resultQuantity = currentQuantity + transactionDto.getQuantity();
        Storage.storage.put(fruit, resultQuantity);
        return resultQuantity;
    }
}
