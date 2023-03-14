package strategy;

import db.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void getAmount(String name, int amount) {
        if (Storage.get(name) == null || Storage.get(name) <= 0
                || Storage.get(name) < amount) {
            throw new RuntimeException("Not enough "
                    + name + " in storage to purchase. "
                    + name + " in storage - " + Storage.get(name));
        }
        Storage.put(name, Storage.get(name) - amount);
    }
}
