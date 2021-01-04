package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class ReductionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        if (transactionDto.getQuantity() < 0) {
            throw new RuntimeException("We can't do this, because quantity is below zero ");
        }
        for (int i = 0; i < transactionDto.getQuantity(); i++) {
            if (!Storage.fruits.remove(transactionDto.getFruit())) {
                throw new RuntimeException("Can't do this, because we have not enough "
                        + transactionDto.getFruit().getName());
            }
        }
    }
}
