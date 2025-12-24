package strategy;

import core.basesyntax.FruitTransaction;
import db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int currentQuantity = Storage.fruitStorage.getOrDefault(transaction.getFruit(), 0);
        int newQuantity = currentQuantity - transaction.getQuantity();

        if (newQuantity < 0) {
            throw new RuntimeException("Not enough fruits to sell: " + transaction.getFruit());
        }

        Storage.fruitStorage.put(transaction.getFruit(), newQuantity);
    }
}
