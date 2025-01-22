package core.basesyntax.tranasctions;


import core.basesyntax.Storage.DateFruits;

public class BalanceOperation implements OperationHandler{
    @Override
    public void resultOfOperation(String fruitName, int amount) {
        if (amount > 0) {
            int currentAmount = DateFruits.get(fruitName);
            int newAmount = currentAmount + amount;
            DateFruits.save(fruitName, newAmount);

        } else {
            throw new RuntimeException(" The balance can`t be less or equals zero");
        }
    }
}
