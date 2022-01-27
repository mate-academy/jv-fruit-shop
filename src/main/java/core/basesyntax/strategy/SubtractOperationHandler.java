package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class SubtractOperationHandler implements OperationHandler {
    @Override
    public boolean apply(TransactionDto transactionDto) {
        int currentQuantity = Storage.storage.get(transactionDto.getFruit()) == null
                ? 0 : Storage.storage.get(transactionDto.getFruit());
        if (currentQuantity - transactionDto.getQuantity() < 0) {
            throw new RuntimeException("Not enough fruits");
        }
        int newQuantity = currentQuantity - transactionDto.getQuantity();
        Storage.storage.put(transactionDto.getFruit(), newQuantity);
        return true;
    }
}
