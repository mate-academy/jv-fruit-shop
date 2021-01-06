package core.basesyntax.strategy;

import core.basesyntax.database.Storage;
import core.basesyntax.model.TransactionDto;

public class AdditionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        if (transactionDto == null) {
            throw new RuntimeException("Transaction dto can't be null!");
        }
        Integer oldNumber = Storage.storage.get(transactionDto.getFruit()) == null ? 0
                : Storage.storage.get(transactionDto.getFruit());
        Storage.storage.put(transactionDto.getFruit(),
                oldNumber + transactionDto.getNumber());
    }
}
