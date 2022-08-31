package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    private Storage dataBase;

    public PurchaseOperationHandler(Storage dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void processingOperation(FruitTransaction transaction) {
        dataBase.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
