package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer processData(String fruitName, Integer quantity) {
        return Storage.getStorage().merge(fruitName, quantity, Integer::sum);
    }
}
