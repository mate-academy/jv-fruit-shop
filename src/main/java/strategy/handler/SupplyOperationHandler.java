package strategy.handler;

import db.FruitStorage;
import model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Integer amount = FruitStorage.storage.getOrDefault(transaction.getFruit(), 0);
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Invalid supply data of fruit: " + transaction.getFruit());
        }
        FruitStorage.storage.put(transaction.getFruit(), amount + transaction.getQuantity());
    }
}
