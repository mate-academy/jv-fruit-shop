package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction input) {
        Storage.dataBase.compute(input.fruit(), (k, oldValue) -> {
            if (input.quantity() > oldValue) {
                throw new RuntimeException(
                        "Wrong transaction value: "
                                + input.quantity()
                                + " is bigger than balance: "
                                + oldValue);
            }
            return oldValue - input.quantity();
        });
    }

    @Override
    public boolean isAplicable(FruitTransaction input) {
        return Operation.PURCHASE == input.operation();
    }
}
