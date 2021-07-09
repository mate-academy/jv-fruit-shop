package strategy;

import dto.Transaction;
import model.Fruit;
import storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        int currentQuantity = transaction.getQuantitiy();
        Storage.fruitStorage.put(new Fruit(transaction.getName()), currentQuantity);
        return currentQuantity;
    }
}
