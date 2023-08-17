package core.basesyntax.service.handles;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BallanceHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.storage.put(transaction.getFruit(),transaction.getQuantity());
    }
}
