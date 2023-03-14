package strategy.impl;

import db.Storage;
import model.TransactionDto;
import strategy.StrategyOperation;

public class PurchaseOperation implements StrategyOperation {
    @Override
    public void apply(TransactionDto transactionDto) {
        int newQuantity = Storage.storage.get(transactionDto.getFruitName())
                - transactionDto.getQuantity();
        if (newQuantity < transactionDto.getQuantity() || newQuantity == 0) {
            throw new RuntimeException("Not enough fruits to sell");
        } else {
            Storage.storage.put(transactionDto.getFruitName(), newQuantity);
        }

    }
}
