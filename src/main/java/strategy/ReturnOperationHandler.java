package strategy;

import db.StorageImpl;
import model.fruitActivitiesModel;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void operate(fruitActivitiesModel transaction) {
        int oldQuantity = StorageImpl.fruitStorage.get(transaction.getFruit());
        StorageImpl.fruitStorage.put(transaction.getFruit(), oldQuantity
                + transaction.getQuantity());
    }
}