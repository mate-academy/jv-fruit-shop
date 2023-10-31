package core.basesyntax.operation;

import static core.basesyntax.storages.FruitStorage.fruitQuantity;

import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void perform(FruitTransaction fruitTransaction) {
        fruitQuantity.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
