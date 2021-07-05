package strategy;

import db.Storage;
import dto.Transaction;
import model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int perform(Transaction transferObject) {
        Storage.getStorage().put(new Fruit(transferObject.getName()), transferObject.getQuantity());
        return transferObject.getQuantity();
    }
}
