package core.basesyntax.strategy;

import java.util.List;

public interface OperationStrategy<T> {
    void get(List<T> transactions);
}
