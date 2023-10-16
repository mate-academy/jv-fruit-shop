package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineInformation;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public boolean operate(LineInformation lineInformation) {
        Fruit fruit = lineInformation.getFruit();
        int amount = lineInformation.getQuantity();
        Storage.storage.put(fruit, Storage.storage.get(fruit) + amount);
        return true;
    }
}
