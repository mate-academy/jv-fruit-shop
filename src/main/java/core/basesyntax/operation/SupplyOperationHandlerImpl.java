package core.basesyntax.operation;

import static core.basesyntax.storages.FruitStorage.fruitQuantity;

import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandlerImpl implements OperationHandler {
    @Override
    public void perform(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int currentQuantity = fruitQuantity.get(fruit);
        fruitQuantity.replace(fruit, currentQuantity + fruitTransaction.getQuantity());
    }
}
