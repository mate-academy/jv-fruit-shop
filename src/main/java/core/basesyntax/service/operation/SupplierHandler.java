package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public class SupplyerHandler implements OperationHandler {

    @Override
    public int getOperationAction(int quantity) {
        return quantity;
    }
}
