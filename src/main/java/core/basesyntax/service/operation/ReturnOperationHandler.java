package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Integer fruitsInStorage = Storage.fruitsMap.get(transaction.getFruit());
        Storage.fruitsMap.put(transaction.getFruit(),
                fruitsInStorage + transaction.getQuantity());
    }
}
