package core.basesyntax.strategy.operations;

import core.basesyntax.model.Transaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(Transaction transaction) {
        transaction.setQuantity(transaction.getQuantity());
    }
}
