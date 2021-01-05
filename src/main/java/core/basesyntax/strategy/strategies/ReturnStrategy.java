package core.basesyntax.strategy.strategies;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class ReturnStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Integer newQuantity = Storage.storage.get(transactionDto.getFruit())
                + operationValidation(transactionDto);
        Storage.storage.replace(transactionDto.getFruit(), newQuantity);
    }

    private int operationValidation(TransactionDto transactionDto) {
        if (transactionDto.getQuantity() < 0) {
            throw new RuntimeException("People cannot return negative amount!");
        }
        return transactionDto.getQuantity();
    }
}
