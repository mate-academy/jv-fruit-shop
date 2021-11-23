package core.basesyntax.strategy.handlerimpls;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseOperation implements OperationHandler {

    @Override
    public int apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getName());
        int currentQuantity = Storage.storage.get(fruit);
        int newQuantity = currentQuantity - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Fruit shop haven't this amount of: "
                    + transaction.getName() + "s");
        }
        Storage.storage.put(fruit, newQuantity);
        return newQuantity;
    }
}
