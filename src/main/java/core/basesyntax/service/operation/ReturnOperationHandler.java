package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int getAmount(Operation operation) {
        return FruitStorage.fruitsWithAmount.get(operation.getFruit()) + operation.getAmount();
    }
}
