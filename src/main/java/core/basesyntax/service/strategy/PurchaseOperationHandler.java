package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineInformation;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public boolean operate(LineInformation lineInformation) {
        Fruit fruit = lineInformation.getFruit();
        int amount = lineInformation.getQuantity();
        if (amount > Storage.storage.get(fruit)) {
            throw new RuntimeException("Sorry, we are out of " + lineInformation.getFruit());
        }
        Storage.storage.put(fruit, Storage.storage.get(fruit) - amount);
        return true;
    }
}
