package core.basesyntax.operation;

import static core.basesyntax.db.FruitStorage.fruitQuantity;

import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void perform(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int currentQuantity = fruitQuantity.get(fruit);
        fruitQuantity.replace(fruit, currentQuantity - fruitTransaction.getQuantity());
    }
}
