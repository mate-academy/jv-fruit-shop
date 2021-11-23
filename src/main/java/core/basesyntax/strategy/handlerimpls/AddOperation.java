package core.basesyntax.strategy.handlerimpls;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class AddOperation implements OperationHandler {

    @Override
    public int apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getName());
        int currentQuantity = Storage.storage.get(fruit);
        int newQuantity = currentQuantity + transaction.getQuantity();
        Storage.storage.put(fruit, newQuantity);
        return newQuantity;
    }
}
