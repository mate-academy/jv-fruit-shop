package strategy;

import db.Storage;
import dto.TransferObject;
import model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int perform(TransferObject transferObject) {
        Storage.getStorage().put(new Fruit(transferObject.getName()), transferObject.getQuantity());
        return transferObject.getQuantity();
    }
}
