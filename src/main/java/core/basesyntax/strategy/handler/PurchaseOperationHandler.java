package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.CantGetFruitException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer processData(String fruitName, Integer quantity) {
        Integer oldQuantity = Storage.getStorage().get(fruitName);
        if (oldQuantity == null) {
            throw new CantGetFruitException("There isn't " + fruitName + " in storage");
        }
        if (oldQuantity < quantity) {
            throw new CantGetFruitException(
                    String.format("Can't get %s %s from storage, available only %s %s",
                            quantity, fruitName, oldQuantity, fruitName));
        }
        Storage.getStorage().put(fruitName, oldQuantity - quantity);
        return Storage.getStorage().get(fruitName);
    }
}
