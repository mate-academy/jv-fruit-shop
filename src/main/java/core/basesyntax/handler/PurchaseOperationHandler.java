package core.basesyntax.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public PurchaseOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitStorage.removeFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
