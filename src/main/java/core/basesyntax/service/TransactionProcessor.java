package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public interface TransactionProcessor {
    void processTransactionList(List<FruitTransaction> list, OperationHandler handlerStrategy);
}
