package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.LineInformation;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public boolean operate(LineInformation lineInformation) {
        Fruit fruitName = lineInformation.getFruit();
        int quantity = lineInformation.getQuantity();
        Storage.storage.put(new Fruit(fruitName.toString()), quantity);
        return true;
    }
}
