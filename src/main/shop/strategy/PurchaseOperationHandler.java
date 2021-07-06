package strategy;

import db.Storage;
import dto.Transaction;
import model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int currentQuantity = Storage.storage.get(fruit);
        int resultQuantity = currentQuantity - transactionDto.getQuantity();
        if (resultQuantity < 0) {
            throw new RuntimeException("There isn't required amount of fruit");
        }
        Storage.storage.put(fruit, resultQuantity);
        return resultQuantity;
    }
}
