package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction input) {
        Storage.dataBase.compute(input.fruit(), (k, oldValue) -> {
            if (input.quantity() < 0) {
                throw new RuntimeException(
                        "Wrong transaction value: "
                                + input.quantity()
                                + " is less than zero");
            }
            return oldValue + input.quantity();
        });
    }

    @Override
    public boolean isAplicable(FruitTransaction input) {
        return "s".equals(input.operation().getCode());
    }
}
