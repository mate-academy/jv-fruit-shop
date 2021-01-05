package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class AdditionStrategyImpl implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        String currentKey = transactionDto.getFruit().getName();
        if (Storage.getFruits().containsKey(currentKey)) {
            Integer newValue = Storage.getFruits().get(currentKey) + transactionDto.getQuantity();
            Storage.getFruits().put(currentKey, newValue);
            return;
        }
        Storage.getFruits().put(currentKey, transactionDto.getQuantity());
    }
}
