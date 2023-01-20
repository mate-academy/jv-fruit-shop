package strategy.handler;

import db.FruitStorage;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        if (FruitStorage.storage.containsKey(transaction.getFruit())) {
            throw new RuntimeException("Data base already contains balance of fruit: "
                    + transaction.getFruit());
        }
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Invalid balance data of fruit: " + transaction.getFruit());
        }
        FruitStorage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
