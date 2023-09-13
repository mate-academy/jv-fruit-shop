package core.basesyntax.strategy;

import core.basesyntax.model.Operation;

public class BalanceAction implements Action {
    @Override
    public int action(Operation operation) {
        return operation.getAmount();
    }
}
