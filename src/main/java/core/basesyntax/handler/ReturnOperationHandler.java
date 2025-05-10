package core.basesyntax.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public ReturnOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitStorage.addFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
