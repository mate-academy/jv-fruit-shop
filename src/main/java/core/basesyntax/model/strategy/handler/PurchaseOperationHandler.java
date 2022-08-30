package core.basesyntax.model.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.service.Storage;

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
