package strategy;

import db.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void getAmount(String name, int amount) {
        if (Storage.get(name) == null) {
            Storage.put(name, amount);
        } else {
            Storage.put(name, Storage.get(name) + amount);
        }
    }
}
