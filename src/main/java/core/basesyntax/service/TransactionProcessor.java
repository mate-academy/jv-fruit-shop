package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.HandlerStrategy;
import java.util.List;

public interface TransactionProcessor {
    void process(List<FruitTransaction> list);
}
