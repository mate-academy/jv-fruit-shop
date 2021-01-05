package core.basesyntax.strategy.strategies;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        operationValidation(transactionDto);
        Storage.storage.put(transactionDto.getFruit(), transactionDto.getQuantity());
    }

    private void operationValidation(TransactionDto transactionDto) {
        if (transactionDto.getQuantity() < 0) {
            Storage.storage.put(transactionDto.getFruit(), 0);
            System.out.println("We can't have negative amount. Setting to 0.");
        }
    }
}
