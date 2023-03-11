package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionLine;

public class SubtractOperationHandler implements OperationHandler {
    @Override
    public void operation(TransactionLine transactionLine) {
        Fruit fruit = new Fruit(transactionLine.getFruitName());
        int quantity = transactionLine.getQuantity();
        int quantityOld = Storage.storage.get(fruit);
        if (quantityOld < quantity) {
            throw new RuntimeException("Not enough fruit for sale ["
                    + quantity + " > " + quantityOld + "]");
        }
        Storage.storage.put(fruit, (quantityOld - quantity));
    }
}
