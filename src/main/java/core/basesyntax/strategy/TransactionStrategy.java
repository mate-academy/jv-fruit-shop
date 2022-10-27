package core.basesyntax.strategy;

import core.basesyntax.strategy.transactions.FruitTransaction;
import java.util.List;

public interface TransactionStrategy {
    void distributeTransactions(List<FruitTransaction> actions);
}
