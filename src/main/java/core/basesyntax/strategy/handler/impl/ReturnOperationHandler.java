package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        int newQuantity = Storage.storage.get(transactionDto.getFruitName())
                + transactionDto.getQuantity();
        Storage.storage.put(transactionDto.getFruitName(), newQuantity);
    }
}
