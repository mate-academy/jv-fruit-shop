package core.basesyntax.service.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        Storage.fruits.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
