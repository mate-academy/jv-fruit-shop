package strategy.impl;

import db.Storage;
import model.TransactionDto;
import strategy.StrategyOperation;

public class SupplyOperation implements StrategyOperation {
    @Override
    public void apply(TransactionDto transactionDto) {
        int newQuantity = Storage.storage.get(transactionDto.getFruitName())
                + transactionDto.getQuantity();
        Storage.storage.put(transactionDto.getFruitName(), newQuantity);
    }
}
