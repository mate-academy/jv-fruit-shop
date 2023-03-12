package core.basesyntax.strategy;

import core.basesyntax.model.Activity;

public interface OperationHandler {
    void process(Activity activity);
}
