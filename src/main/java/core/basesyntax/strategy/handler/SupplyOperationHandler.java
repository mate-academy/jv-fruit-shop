package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    private Storage dataBase;

    public SupplyOperationHandler(Storage dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void processingOperation(FruitTransaction transaction) {
        dataBase.add(transaction.getFruit(), transaction.getQuantity());
    }
}
