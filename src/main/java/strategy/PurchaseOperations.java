package strategy;

import dto.Transaction;
import model.TheFruit;
import storage.TheStorage;

public class PurchaseOperations implements OperationVariables {
    @Override
    public int apply(Transaction transaction) {
        TheFruit fruit = new TheFruit(transaction.getName());
        int currentQuantity = TheStorage.iStorage.get(fruit) - transaction.getQuantitiy();
        if (currentQuantity < 0) {
            throw new RuntimeException("Not enough fruit`s Bro");
        }
        TheStorage.iStorage.put(fruit, currentQuantity);
        return currentQuantity;
    }
}
