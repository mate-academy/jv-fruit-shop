package core.basesyntax.strategy;

import core.basesyntax.service.OperationSelector;

public interface OperationStrategy {
    public OperationSelector get(String type);
}
