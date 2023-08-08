package core.basesyntax.service.handlers;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.storage.Storage;

public class SupplyHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        if (Storage.storage.containsKey(transaction.getFruit())) {
            Integer quantity = Storage.storage.get(transaction.getFruit());
            Storage.storage.put(transaction.getFruit(), quantity + transaction.getQuantity());
        } else {
            Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
