package strategy;

import db.Storage;
import model.Fruit;
import model.TransactionDto;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        if (!Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, transactionDto.getQuantity());
        }
    }
}
