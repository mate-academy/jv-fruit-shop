package core.basesyntax.strategy.implementations;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class PurchaseStrategy implements OperationStrategy {

    @Override
    public void apply(TransactionDto transactionObject, int quantity) {
        dao.subtractFromStorage(transactionObject.getItem(), transactionObject.getQuantity());
    }
}
