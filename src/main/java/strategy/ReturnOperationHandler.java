package strategy;

import db.StorageImpl;
import model.FruitActivitiesModel;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitActivitiesModel transaction) {
        int oldQuantity = StorageImpl.fruitStorage.get(transaction.getFruit());
        StorageImpl.fruitStorage.put(transaction.getFruit(), oldQuantity
                + transaction.getQuantity());
    }
}
