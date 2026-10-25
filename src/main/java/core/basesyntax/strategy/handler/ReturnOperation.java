package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Integer current = Storage.get(fruit);
        int currentQuantity = (current == null) ? 0 : current;

        int newQuantity = currentQuantity + quantity;
        Storage.put(fruit, newQuantity);
    }
}
