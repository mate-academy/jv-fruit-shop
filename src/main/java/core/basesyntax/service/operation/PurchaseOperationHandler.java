package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getAmount(Operation operation) {
        int newAmount = FruitStorage.fruitsWithAmount
                .get(operation.getFruit()) - operation.getAmount();
        if (newAmount < 0) {
            throw new RuntimeException("Can't sell more fruits than we have in storage");
        }
        return newAmount;
    }
}
