package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineInformation;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public boolean operate(LineInformation lineInformation) {
        Fruit fruit = new Fruit(lineInformation.getFruit().toString());
        int amount = lineInformation.getQuantity();
        Storage.storage.put(fruit, Storage.storage.get(fruit) + amount);
        return true;
    }
}
