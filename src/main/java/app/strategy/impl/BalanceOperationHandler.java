package app.strategy.impl;

import app.db.Storage;
import app.dto.Transaction;
import app.model.Fruit;
import app.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        int currentQuantity = transactionDto.getQuantity();
        Storage.storage.put(new Fruit(transactionDto.getName()), currentQuantity);
        return currentQuantity;
    }
}
