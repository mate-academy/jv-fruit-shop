package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruits;
import core.basesyntax.model.TransactionDto;

public class OperationAddition implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        for (int i = 0; i < transactionDto.getQuantity(); i++) {
            Storage.fruits.add(new Fruits(transactionDto.getFruit()));
        }
    }
}
