package core.basesyntax.strategy.operations;

import core.basesyntax.db.FruitMap;
import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void initializeOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getFruit() == null) {
            throw new FruitShopException("Invalid input data");
        }
        if (fruitTransaction.getQuantity() <= 0) {
            throw new FruitShopException(fruitTransaction.getQuantity()
                    + " is invalid quantity!");
        }
        if (!FruitMap.fruitMap.containsKey(fruitTransaction.getFruit())) {
            throw new FruitShopException(fruitTransaction.getFruit()
                    + " don`t exist in data base!");
        }
        FruitMap.fruitMap.put(fruitTransaction.getFruit(),
                FruitMap.fruitMap.get(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}
