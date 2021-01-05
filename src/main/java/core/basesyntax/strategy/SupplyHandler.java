package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.ValidateOperationImpl;

public class SupplyHandler implements OperationHandler {
    ValidateOperationImpl validation = new ValidateOperationImpl();

    @Override
    public void apply(Storage storage, Fruit fruit, int amount) {
        validation.validate(storage, fruit, amount);
        storage.getStorage().put(fruit, storage.getStorage().get(fruit) + amount);
    }
}
