package strategy;

import db.Storage;
import model.FruitTransaction;

public class BalanceHandler implements OperationHandler {

    @Override
    public void operate(FruitTransaction transaction) {
        Storage.dataBase.put(transaction.getFruit(), transaction.getQuantity());
    }
}
