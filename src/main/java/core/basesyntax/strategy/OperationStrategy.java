package core.basesyntax.strategy;

import java.util.List;

public interface OperationStrategy {
    void accept(List<String> data);
}
