package core.basesyntax.service.strategy;

import core.basesyntax.model.LineData;

public interface TransactionStrategy {
    OperationHandler get(LineData lineData);
}
