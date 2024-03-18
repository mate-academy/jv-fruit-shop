package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface TransactionServiceStrategy {
    void processData(List<FruitTransaction> transactions);
}
