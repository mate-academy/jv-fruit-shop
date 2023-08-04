package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.CantPutFruitException;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer processData(String fruitName, Integer quantity) {
        if (Storage.getStorage().get(fruitName) != null) {
            throw new CantPutFruitException(fruitName + "already exist in Storage");
        }
        return Storage.getStorage().put(fruitName, quantity);
    }
}
