package core.basesyntax.service.handles;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handler(FruitTransaction transaction) {
        Integer quantity = Storage.storage.get(transaction.getFruit());
        Storage.storage.put(transaction.getFruit(), quantity + transaction.getQuantity());
    }
}
