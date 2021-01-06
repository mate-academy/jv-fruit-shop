package core.basesyntax.strategy.implementations;

import core.basesyntax.dao.OperationsDao;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceStrategy implements OperationStrategy {
    private final OperationsDao dao;

    public BalanceStrategy(OperationsDao dao) {
        this.dao = dao;
    }

    @Override
    public void apply(TransactionDto transactionObject) {
        dao.addToStorage(transactionObject.getItem(), transactionObject.getQuantity());
    }
}
