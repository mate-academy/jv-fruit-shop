package core.basesyntax.strategy;

import core.basesyntax.db.FruitMapImpl;
import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.FruitTransaction;

public class BalanceStrategy implements OperationHandler {
    @Override
    public void initializeOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getFruit() == null) {
            throw new FruitShopException("Invalid input data");
        }
        if (fruitTransaction.getQuantity() <= 0) {
            throw new FruitShopException(fruitTransaction.getQuantity() + " is invalid quantity!");
        }
        FruitMapImpl.fruitMap.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
