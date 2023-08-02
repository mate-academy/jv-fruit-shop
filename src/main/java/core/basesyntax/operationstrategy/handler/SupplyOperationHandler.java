package core.basesyntax.operationstrategy.handler;

import core.basesyntax.db.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer processData(String fruitName, Integer quantity) {
        return Storage.getStorage().merge(fruitName, quantity, Integer::sum);
    }
}
