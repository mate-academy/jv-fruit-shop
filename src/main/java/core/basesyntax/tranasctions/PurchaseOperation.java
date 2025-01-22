package core.basesyntax.tranasctions;

import core.basesyntax.Storage.DateFruits;

public class PurchaseOperation implements OperationHandler{
    @Override
    public void resultOfOperation(String fruitName, int amount) {
        int currentAmount = DateFruits.get(fruitName);
        int newAmount = currentAmount - amount;
        DateFruits.save(fruitName, newAmount);
    }
}
