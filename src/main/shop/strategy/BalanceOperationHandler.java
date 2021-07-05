package strategy;

import db.Storage;
import dto.Transaction;
import model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int quantity = transactionDto.getQuantity();
        Storage.storage.put(fruit, quantity);
        return quantity;
    }
}
