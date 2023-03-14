package strategy.impl;

import db.Storage;
import model.TransactionDto;
import strategy.StrategyOperation;

public class BalanceOperation implements StrategyOperation {
    @Override
    public void apply(TransactionDto transactionDto) {
        Storage.storage.put(transactionDto.getFruitName(), transactionDto.getQuantity());
    }
}
