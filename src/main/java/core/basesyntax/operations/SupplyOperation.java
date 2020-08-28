package core.basesyntax.operations;

import core.basesyntax.Fruit;
import core.basesyntax.Storage;
import core.basesyntax.Transaction;

public class SupplyOperation extends AbstactOperation implements StoreOperation {
    public SupplyOperation(Storage storage) {
        super(storage);
    }

    @Override
    public void performOperation(Transaction transaction) {
        for (int i = 0; i < transaction.getQuantity(); i++) {
            storage.addFruit(new Fruit(transaction.getFruitName(), transaction.getDate()));
        }
    }
}
