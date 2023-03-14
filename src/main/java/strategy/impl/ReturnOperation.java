package strategy.impl;

import db.Storage;
import model.TransactionDto;
import strategy.StrategyOperation;

public class ReturnOperation implements StrategyOperation {
    @Override
    public void apply(TransactionDto transactionDto) {
        int oldQuantity = Storage.storage.get(transactionDto.getFruitName());
        int newQuantity = oldQuantity + transactionDto.getQuantity();
        Storage.storage.put(transactionDto.getFruitName(), newQuantity);
    }
}
