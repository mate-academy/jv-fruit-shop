package core.basesyntax.service.strategy;

import core.basesyntax.model.LineData;

public interface OperationHandler {
    boolean operate(LineData lineData);
}
