package core.basesyntax.stratege;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void doOperation(TransactionDto transactionDto) {
        if (transactionDto.getQuantity() < 0) {
            throw new IllegalArgumentException("Balance can't be negative number "
                    + transactionDto.getQuantity());
        }
        Storage.fruitsAndAmountsMap.put(transactionDto.getFruit(), transactionDto.getQuantity());
    }
}
