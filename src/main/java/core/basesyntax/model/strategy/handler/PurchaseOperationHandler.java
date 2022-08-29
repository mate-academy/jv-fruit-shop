package core.basesyntax.model.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.service.DataBase;

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
