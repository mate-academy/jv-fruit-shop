package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.ValidateOperationImpl;

public class SupplyHandler implements OperationHandler {
    ValidateOperationImpl validation = new ValidateOperationImpl();

    @Override
    public void apply(Fruit fruit, int amount) {
        validation.validate(fruit, amount);
        Storage.getStorage().put(fruit, Storage.getStorage().get(fruit) + amount);
    }
}
