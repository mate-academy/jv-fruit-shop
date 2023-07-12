package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class ReturnOperationHandler implements OperationHandler {
    private Storage dataBase;

    public ReturnOperationHandler(Storage dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void processingOperation(FruitTransaction transaction) {
        dataBase.add(transaction.getFruit(), transaction.getQuantity());
    }
}
