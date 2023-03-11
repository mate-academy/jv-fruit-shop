package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionLine;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void operation(TransactionLine transactionLine) {
        Fruit fruit = new Fruit(transactionLine.getFruitName());
        int quantity = transactionLine.getQuantity();
        int quantityOld = Storage.storage.get(fruit);
        Storage.storage.put(fruit, (quantityOld + quantity));
    }
}
