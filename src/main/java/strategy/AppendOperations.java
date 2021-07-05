package strategy;

import dto.Transaction;
import model.TheFruit;
import storage.TheStorage;

public class AppendOperations implements OperationVariables {
    @Override
    public int apply(Transaction transaction) {
        TheFruit fruit = new TheFruit(transaction.getName());
        int currentQuantity = TheStorage.iStorage
                .getOrDefault(new TheFruit(transaction.getName()), 0);
        TheStorage.iStorage.put(fruit, currentQuantity + transaction.getQuantitiy());
        return currentQuantity + transaction.getQuantitiy();
    }
}
