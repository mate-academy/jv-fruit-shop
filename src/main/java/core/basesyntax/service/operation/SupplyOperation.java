package core.basesyntax.service.operation;

import core.basesyntax.service.FruitStorage;
import core.basesyntax.service.FruitTransaction;

public class SupplyOperation implements OperationHandler {

    @Override
    public FruitStorage operation(FruitTransaction fruitTransaction, FruitStorage fruitStorage) {
        if (fruitTransaction.getFruit().equals(fruitStorage.getFruit())) {
            fruitStorage.addFruit(fruitTransaction.getQuantity());
        }
        return fruitStorage;
    }
}
