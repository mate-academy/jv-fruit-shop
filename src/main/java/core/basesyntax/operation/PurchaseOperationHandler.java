package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.storage.DataBase;

public class PurchaseOperationHandler implements OperationHandler {
    private DataBase dataBase;

    public PurchaseOperationHandler(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void processingOperation(FruitTransaction transaction) {
        dataBase.remove(transaction.getFruit(), transaction.getQuantity());
    }
}
