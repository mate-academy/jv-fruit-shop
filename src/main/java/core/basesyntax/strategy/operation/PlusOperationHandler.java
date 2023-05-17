package core.basesyntax.strategy.operation;

import core.basesyntax.exception.NegativeNumberException;

public class PlusOperationHandler implements OperationHandler {
    @Override
    public Integer handle(Integer currentQuantity, Integer operationQuantity) {
        currentQuantity = (currentQuantity != null) ? currentQuantity : 0;
        if (operationQuantity <= 0) {
            throw new NegativeNumberException();
        }
        int result = currentQuantity + operationQuantity;
        if (result <= 0) {
            throw new NegativeNumberException();
        }
        return result;
    }
}
