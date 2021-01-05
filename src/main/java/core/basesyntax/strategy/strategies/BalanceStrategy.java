package core.basesyntax.strategy.strategies;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Storage.storage.put(transactionDto.getFruit(), operationValidation(transactionDto));
    }

    private int operationValidation(TransactionDto transactionDto) {
        if (transactionDto.getQuantity() < 0) {
            System.out.println("We can't have negative amount. Setting to 0.");
            return 0;
        }
        return transactionDto.getQuantity();
    }
}
