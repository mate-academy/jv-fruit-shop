package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int newQuantity = transaction.getQuantity();
        if (Storage.fruits.containsKey(fruitName)) {
            int oldQuantity = Storage.fruits.get(fruitName);
            Storage.fruits.put(fruitName, oldQuantity + newQuantity);
        } else {
            Storage.fruits.put(fruitName, newQuantity);
        }
    }
}
