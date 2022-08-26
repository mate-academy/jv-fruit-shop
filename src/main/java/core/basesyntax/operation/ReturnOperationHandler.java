package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.storage.DataBase;

public class ReturnOperationHandler implements OperationHandler {
    private DataBase dataBase;

    public ReturnOperationHandler(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void processingOperation(FruitTransaction transaction) {
        dataBase.add(transaction.getFruit(), transaction.getQuantity());
    }
}
