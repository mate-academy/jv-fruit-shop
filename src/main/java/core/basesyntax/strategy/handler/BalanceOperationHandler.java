package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.CantPutFruitException;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer processData(String fruitName, Integer quantity) {
        if (getStorage().get(fruitName) != null) {
            throw new CantPutFruitException(fruitName + "already exist in Storage");
        }
        return getStorage().put(fruitName, quantity);
    }

    private Map<String, Integer> getStorage() {
        return Storage.getStorage();
    }
}
