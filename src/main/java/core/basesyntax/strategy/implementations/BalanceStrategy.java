package core.basesyntax.strategy.implementations;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionObject, int quantity) {
        dao.addToStorage(transactionObject.getItem(), transactionObject.getQuantity());
    }
}
