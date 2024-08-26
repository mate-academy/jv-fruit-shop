package core.basesyntax.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitStorage fruitStorage;

    public BalanceOperationHandler(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitStorage.setFruitBalance(transaction.getFruit(), transaction.getQuantity());
    }
}
