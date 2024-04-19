package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer calculateQuantity(Integer before, Integer after) {
        return before + after;
    }
}
