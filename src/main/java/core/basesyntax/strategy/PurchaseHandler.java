package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.OperationException;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.impl.ValidateOperationImpl;

public class PurchaseHandler implements OperationHandler {
    ValidateOperationImpl validation = new ValidateOperationImpl();

    @Override
    public void apply(Fruit fruit, int amount) {
        validation.validate(fruit, amount);
        if (!Storage.getStorage().containsKey(fruit)) {
            throw new RuntimeException("We haven`t this fruit at storage");
        } else if (amount > Storage.getStorage().get(fruit)) {
            throw new OperationException("We can't sell more than we have");
        }
        Storage.getStorage().put(fruit, Storage.getStorage().get(fruit) - amount);
    }
}
