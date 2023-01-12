package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface TransactionProcessor {
    void process(List<FruitTransaction> transactions);
}
