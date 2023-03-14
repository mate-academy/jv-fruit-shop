package strategy.impl;

import db.Storage;
import model.TransactionDto;
import strategy.StrategyOperation;

public class PurchaseOperation implements StrategyOperation {
    @Override
    public void apply(TransactionDto transactionDto) {
        int oldQuantity = Storage.storage.get(transactionDto.getFruitName());
        int newQuantity = oldQuantity - transactionDto.getQuantity();

        if (oldQuantity < transactionDto.getQuantity() || oldQuantity == 0) {
            throw new RuntimeException("Not enough fruits to sell");
        } else {
            Storage.storage.put(transactionDto.getFruitName(), newQuantity);
        }

    }
}
