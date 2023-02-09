package core.basesyntax.service.impl.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        new SupplyOperationHandler().handle(transaction);
    }
}
