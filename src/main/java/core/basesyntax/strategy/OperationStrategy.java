package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;

public interface OperationStrategy {
    void apply(TransactionDto transactionDto);

    default void checkExceptionNegativeCount(TransactionDto transactionDto) {
        if (transactionDto.getCount() < 0) {
            throw new RuntimeException("Attention! " + transactionDto.getCount()
                    + " " + transactionDto.getFruit().getName() + "(s) is incorrect input.");
        }
    }
}
