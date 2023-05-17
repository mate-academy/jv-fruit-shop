package strategy;

import db.StorageImpl;
import model.FruitActivitiesModel;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitActivitiesModel transaction) {
        StorageImpl.fruitStorage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
