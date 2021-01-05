package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.OperationException;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.ValidateOperationImpl;

public class PurchaseHandler implements OperationHandler {
    ValidateOperationImpl validation = new ValidateOperationImpl();

    @Override
    public void apply(Storage storage, Fruit fruit, int amount) {
        validation.validate(storage, fruit, amount);
        if (amount > storage.getStorage().get(fruit)) {
            throw new OperationException("We can't sell more than we have");
        }
        storage.getStorage().put(fruit, storage.getStorage().get(fruit) - amount);
    }
}
