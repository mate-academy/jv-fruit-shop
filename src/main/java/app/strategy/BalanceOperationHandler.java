package app.strategy;

import app.db.Storage;
import app.dto.Transaction;
import app.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        int currentQuantity = transactionDto.getQuantity();
        Storage.storage.put(new Fruit(transactionDto.getName()), currentQuantity);
        return currentQuantity;
    }
}
