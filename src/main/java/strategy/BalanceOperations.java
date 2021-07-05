package strategy;

import dto.Transaction;
import model.TheFruit;
import storage.TheStorage;

public class BalanceOperations implements OperationVariables {

    @Override
    public int apply(Transaction transaction) {
        int currentQuantity = transaction.getQuantitiy();
        TheStorage.iStorage.put(new TheFruit(transaction.getName()), currentQuantity);
        return currentQuantity;
    }
}
