package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
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
