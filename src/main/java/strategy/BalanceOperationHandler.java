package strategy;

import db.StorageImpl;
import model.fruitActivitiesModel;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(fruitActivitiesModel transaction) {
        StorageImpl.fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
