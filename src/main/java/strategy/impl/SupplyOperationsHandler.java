package strategy.impl;

import java.util.Map;
import model.FruitTransaction;
import storage.Storage;
import strategy.OperationsHandler;

public class SupplyOperationsHandler implements OperationsHandler {
    @Override
    public void useOperation(FruitTransaction transaction) {
        int balance = Storage.getStorage().get(transaction.getName());
        int supply = balance + transaction.getQuantity();
        Map<String, Integer> storage = Storage.getStorage();
        storage.put(transaction.getName(), supply);
    }
}
