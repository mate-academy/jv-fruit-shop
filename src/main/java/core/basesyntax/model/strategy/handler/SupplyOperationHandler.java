package core.basesyntax.model.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.service.DataBase;

public class SupplyOperationHandler implements OperationHandler {
    private DataBase dataBase;

    public SupplyOperationHandler(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void processingOperation(FruitTransaction transaction) {
        dataBase.add(transaction.getFruit(), transaction.getQuantity());
    }
}
