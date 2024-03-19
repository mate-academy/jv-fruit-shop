package core.basesyntax;

import core.basesyntax.model.FruitsTransaction;

public interface OperationHandler {
    void apply(FruitsTransaction transaction);
    boolean isApplicable(FruitsTransaction transaction);
}
