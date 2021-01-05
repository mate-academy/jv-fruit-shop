package core.basesyntax.strategy.strategies;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class ReturnStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        operationValidation(transactionDto);
        Integer newQuantity = Storage.storage.get(transactionDto.getFruit())
                + transactionDto.getQuantity();
        Storage.storage.replace(transactionDto.getFruit(), newQuantity);
    }

    private void operationValidation(TransactionDto transactionDto) {
        if (transactionDto.getQuantity() < 0) {
            throw new RuntimeException("People cannot return negative amount!");
        }
    }
}
