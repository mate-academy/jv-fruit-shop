package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        if (!storage.findFruit(fruit)) {
            storage.addFruitWithQuantity(fruit, 0);
        }
        int currentQuantity = storage.findQuantity(fruit);
        int returnQuantity = fruitTransaction.getQuantity();
        storage.addFruitWithQuantity(fruit, currentQuantity + returnQuantity);
    }
}
