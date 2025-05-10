package core.basesyntax.service.operation;

import core.basesyntax.service.FruitStorage;
import core.basesyntax.service.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public FruitStorage operation(FruitTransaction fruitTransaction, FruitStorage fruitStorage) {
        if (fruitTransaction.getFruit().equals(fruitStorage.getFruit())) {
            fruitStorage.subtractFruit(fruitTransaction.getQuantity());
        }
        return fruitStorage;
    }
}
