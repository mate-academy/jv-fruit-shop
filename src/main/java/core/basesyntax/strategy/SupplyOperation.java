package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private final Storage storage;

    public SupplyOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        if (!storage.findFruit(fruit)) {
            storage.addFruitWithQuantity(fruit, 0);
        }
        int currentQuantity = storage.findQuantity(fruit);
        int supplyQuantity = fruitTransaction.getQuantity();
        storage.addFruitWithQuantity(fruit, currentQuantity + supplyQuantity);
    }
}
