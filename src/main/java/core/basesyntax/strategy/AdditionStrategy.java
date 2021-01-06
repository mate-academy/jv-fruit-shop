package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class AdditionStrategy implements OperationStrategy {

    @Override
    public void apply(TransactionDto transactionDto) {
        checkExceptionNegativeCount(transactionDto);
        for (int i = 0; i < transactionDto.getCount(); i++) {
            Storage.fruits.add(transactionDto.getFruit());
        }
    }
}
