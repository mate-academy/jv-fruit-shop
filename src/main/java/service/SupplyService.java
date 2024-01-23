package service;

import model.FruitTransaction;
import storage.Storage;

public class SupplyService implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        Storage.getFruitsStorage().merge(transaction.getName(),
                transaction.getQuantity(), Integer::sum);
    }
}
