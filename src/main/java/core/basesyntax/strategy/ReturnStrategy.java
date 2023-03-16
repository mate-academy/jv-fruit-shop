package core.basesyntax.strategy;

import core.basesyntax.db.FruitMap;
import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.FruitTransaction;

public class ReturnStrategy implements OperationHandler {
    @Override
    public void initializeOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getFruit() == null) {
            throw new FruitShopException("Invalid input data");
        }
        if (fruitTransaction.getQuantity() <= 0) {
            throw new FruitShopException(fruitTransaction.getQuantity() + " is invalid quantity!");
        }
        FruitMap.fruitMap.put(fruitTransaction.getFruit(),
                FruitMap.fruitMap.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
