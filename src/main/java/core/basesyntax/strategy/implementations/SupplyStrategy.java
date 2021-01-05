package core.basesyntax.strategy.implementations;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class SupplyStrategy implements OperationStrategy {

    @Override
    public void apply(TransactionDto transactionObject) {
        dao.addToStorage(transactionObject.getItem(), transactionObject.getQuantity());
    }
}
