package core.basesyntax;

import java.util.List;

public interface OperationStrategy {
    void process(List<FruitTransaction> transactions);
}
