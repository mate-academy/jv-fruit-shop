package core.basesyntax.strategy;

import core.basesyntax.dao.OperationsDao;
import core.basesyntax.model.TransactionDto;

public interface OperationStrategy {
    OperationsDao dao = new OperationsDao();

    void apply(TransactionDto transactionObject, int quantity);
}
