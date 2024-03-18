package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.HandlerStrategy;
import java.util.List;

public interface TransactionProcessor {
    void processTransactionList(List<FruitTransaction> list, HandlerStrategy handlerStrategy);
}
