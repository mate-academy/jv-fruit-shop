package core.basesyntax.strategy;

import java.util.List;

public interface OperationStrategy<T> {
    void calculateTransactions(List<T> transactions);
}
