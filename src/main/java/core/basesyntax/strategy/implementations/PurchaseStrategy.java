package core.basesyntax.strategy.implementations;

import core.basesyntax.dao.OperationsDao;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class PurchaseStrategy implements OperationStrategy {
    private final OperationsDao dao;

    public PurchaseStrategy(OperationsDao dao) {
        this.dao = dao;
    }

    @Override
    public void apply(TransactionDto transactionObject) {
        dao.subtractFromStorage(transactionObject.getItem(), transactionObject.getQuantity());
    }
}
